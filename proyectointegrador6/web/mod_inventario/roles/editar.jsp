<%-- 
    Document   : editar
    Created on : 09/01/2019, 17:27:36
    Author     : sairy
--%>
<%@page import="ReglasDeNegocio.Roles"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Roles roles= new Roles();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         roles=Roles.roles_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Roles</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=roles.getRolid()%>">
              <input type="text" required class="form-control" placeholder="Nombre_rol Roles" id="nombre_rol_roles" value="<%=roles.getNombre_rol()%>" name="nombre_rol_roles"/>
              <input type="text" required class="form-control" placeholder="Descripcion Roles" id="decripcion_roles" value="<%=roles.getDescripcion()%>" name="descripcion_roles"/>
      
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>