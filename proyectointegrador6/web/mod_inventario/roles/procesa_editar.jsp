

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
    try {
            Roles roles=new Roles();
            roles.setNombre_rol(request.getParameter("nombre_rol_roles"));
            roles.setDescripcion(request.getParameter("descripcion_roles"));
            
            roles.setRolid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Roles.roles_editar(roles);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>