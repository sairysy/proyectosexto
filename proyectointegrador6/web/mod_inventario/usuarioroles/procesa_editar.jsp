<%@page import="java.sql.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<%@page import="AccesoADatos.*"%>
<!DOCTYPE html>
<%
    try {
            Usuariorol usuariorol=new Usuariorol();
           
            Usuarios usuarios = new Usuarios();
            Usuarios usuarioss = usuarios.usuarios_buscarporid(Integer.valueOf(request.getParameter("usuarioid")));
            usuariorol.setUsuarios(usuarioss);            
           
            Roles roles = new Roles();
            Roles roless = roles.roles_buscarporid(Integer.valueOf(request.getParameter("rolid")));
            usuariorol.setRoles(roless); 
           boolean result= Usuariorol.usuariorol_editar(usuariorol);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>
