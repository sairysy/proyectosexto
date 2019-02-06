<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 List<Roles> listap= Roles.roles_buscartodos();
 Iterator<Roles> itRoles=listap.iterator();
%>
<%
 List<Paginas> lista= Paginas.paginas_buscartodos();
 Iterator<Paginas> itPaginas=lista.iterator();
%>


<%!
   Rolpagina rolpagina= new Rolpagina();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         rolpagina=Rolpagina.rolpagina_buscarporid(codigo);                       
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
          <input type="hidden" id="codigo" name="codigo" value="<%=rolpagina.getRolpaginaid()%>">  
          
           
            <select required class="form-control" placeholder="Rolid Roles" id="rolid" value="<%=rolpagina.getRoles()%>"  name="rolid">
          
            <%while(itRoles.hasNext()){
                Roles roles=itRoles.next();%> %>
            <option value="<%=roles.getRolid()%>"><%=roles.getNombre_rol()%></option>
            <% } %>
                                  
            </select> 
            
          <select required class="form-control" placeholder="Paginaid Paginas" id="paginaid" value="<%=rolpagina.getPaginas()%>"  name="paginaid">
          
            <%while(itPaginas.hasNext()){
                Paginas paginas=itPaginas.next();%> %>
                <option value="<%=paginas.getPaginaid()%>"><%=paginas.getUrl()%></option>
            <% } %>
                                  
            </select>
          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>