<%-- 
    Document   : editar
    Created on : 09/01/2019, 17:27:36
    Author     : sairy
--%>
<%@page import="ReglasDeNegocio.Usuarios"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Usuarios usuarios= new Usuarios();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         usuarios=Usuarios.usuarios_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuarios</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=usuarios.getUsuarioid()%>">
              <input type="text" required class="form-control" placeholder="Nombre_usuario Usuarios" id="nombre_usuario_usuarios" value="<%=usuarios.getNombre_usuario()%>" name="nombre_usuario_usuarios"/>
              <input type="text" required class="form-control" placeholder="Contrasenia Usuarios" id="contraseña_usuarios" value="<%=usuarios.getContrasenia()%>" name="contrasenia_usuarios"/>
          <input type="text" required class="form-control" placeholder="Cedula Usuarios" id="cedula_usuarios" value="<%=usuarios.getCedula()%>" name="cedula_usuarios"/>
          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>