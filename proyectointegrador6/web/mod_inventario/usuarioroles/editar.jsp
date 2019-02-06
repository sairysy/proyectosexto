<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Usuarios> lista= Usuarios.usuarios_buscartodos();
 Iterator<Usuarios> itUsuarios=lista.iterator();
%>
<%
 List<Roles> listap= Roles.roles_buscartodos();
 Iterator<Roles> itRoles=listap.iterator();
%>



<%!
   Usuariorol usuariorol= new Usuariorol();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         usuariorol=Usuariorol.usuariorol_buscarporid(codigo);                       
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Venta</title>
     
    </head>
    
    <body>                    
          <form method="POST" action="procesa_editar.jsp">
          <input type="hidden" id="codigo" name="codigo" value="<%=usuariorol.getUsuariorolid()%>">  
          
          <select required class="form-control" placeholder="Usuarioid Usuarios" id="usuarioid" value="<%=usuariorol.getUsuarios()%>"  name="usuarioid">
          
            <%while(itUsuarios.hasNext()){
                Usuarios usuarios=itUsuarios.next();%> %>
            <option value="<%=usuarios.getUsuarioid()%>"><%=usuarios.getNombre_usuario()%></option>
            <% } %>
                                  
            </select> 
            <select required class="form-control" placeholder="Rolid Roles" id="rolid" value="<%=usuariorol.getRoles()%>"  name="rolid">
          
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