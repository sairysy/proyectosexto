
<%@page import="ReglasDeNegocio.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
try {
       boolean result =Sg_pagina.sg_pagina_eliminar(Integer.valueOf(request.getParameter("codigo")));
        if (result)
        out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
        else 
        out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

       
    } catch (Exception e) {
        out.print(e.toString());
    }
%>

