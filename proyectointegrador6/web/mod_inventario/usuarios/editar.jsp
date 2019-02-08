<%@page import="ReglasDeNegocio.Sg_usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Sg_usuario usuario= new Sg_usuario();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         usuario= Sg_usuario.sg_usuarios_buscarporid(codigo);
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=usuario.getUsuarioid()%>">
              <input type="text" required class="form-control" placeholder="Nombre Usuario" id="nombre_usuario" value="<%=usuario.getNombre_usuario()%>" name="nombre_usuario"/>
          <input type="text" required class="form-control" placeholder="Contrasenia" id="contrasenia" value="<%=usuario.getContrasenia()%>" name="contrasenia"/>
          <input type="text" required class="form-control" placeholder="Identificacion" id="identificacion" value="<%=usuario.getIdentificacion()%>" name="identificacion"/>
          
         
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>