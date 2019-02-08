<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>

<!DOCTYPE html>

<%
    try {
           Sg_usuario sg_usuario = new Sg_usuario();
           sg_usuario.setNombre_usuario(request.getParameter("nombre_usuario"));
           sg_usuario.setContrasenia(request.getParameter("contrasenia"));
           sg_usuario.setIdentificacion(request.getParameter("identificacion"));
           boolean result= Sg_usuario.sg_usuario_insertar(sg_usuario);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");
        } catch (Exception e) {
            out.print(e.getMessage());
        }

%>



