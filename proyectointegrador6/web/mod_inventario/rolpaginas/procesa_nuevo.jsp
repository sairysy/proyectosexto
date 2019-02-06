<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.sql.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>

<!DOCTYPE html>

<%
    try {
            Rolpagina rolpagina=new Rolpagina();
            
                          
            
            Roles roles= new Roles();
            Roles roless = roles.roles_buscarporid(Integer.valueOf(request.getParameter("rolid")));
            rolpagina.setRoles(roless); 
            
             Paginas paginas = new Paginas();
            Paginas paginass = paginas.paginas_buscarporid(Integer.valueOf(request.getParameter("paginaid")));
            rolpagina.setPaginas(paginass);   
            boolean result= Rolpagina.rolpagina_insertar(rolpagina);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");
        } catch (Exception e) {
            out.print(e.getMessage());
        }

%>
