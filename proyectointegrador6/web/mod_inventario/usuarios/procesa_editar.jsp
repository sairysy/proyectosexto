

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
    try {
            Usuarios usuarios=new Usuarios();
            usuarios.setNombre_usuario(request.getParameter("nombre_usuario_usuarios"));
            usuarios.setContrasenia(request.getParameter("contrasenia_usuarios"));
            usuarios.setCedula(request.getParameter("cedula_usuarios"));
            usuarios.setUsuarioid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Usuarios.usuarios_editar(usuarios);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>