
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AccesoADatos.*"%>
<%
 List<Usuarios> lista= Usuarios.usuarios_buscartodos();
 Iterator<Usuarios> itUsuarios=lista.iterator();
%>
<%
 List<Roles> listap= Roles.roles_buscartodos();
 Iterator<Roles> itRoles=listap.iterator();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario_Rol</title>
        
    </head>
    <body>        
            <form method="POST"  action="procesa_nuevo.jsp">
           
            <select class="form-control" placeholder="usuarioid" required id="categoriaid" name="usuarioid">  
            <option>Usuarios</option>
            <%while(itUsuarios.hasNext()){
                Usuarios usuarios=itUsuarios.next();%> %>
                <option value="<%=usuarios.getUsuarioid()%>"><%=usuarios.getNombre_usuario()%></option>
            <% } %>                             
            </select>
               
            
            <select class="form-control" placeholder="rolid" required id="categoriaid" name="rolid">  
            <option>Roles</option>
            <%while(itRoles.hasNext()){
                Roles roles=itRoles.next();%> %>
                <option value="<%=roles.getRolid()%>"><%=roles.getNombre_rol()%></option>
            <% } %>                             
            </select>
              
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>