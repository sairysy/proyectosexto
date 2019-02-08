

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
         try {
           Sg_rol sg_roles=new Sg_rol();
            sg_roles.setNombre_rol(request.getParameter("nombre_rol"));
            sg_roles.setDescripcion(request.getParameter("descripcion"));
            
           boolean result= Sg_rol.sg_rol_insertar(sg_roles);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                 out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

  
 %>
