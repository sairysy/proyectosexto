<%-- 
    Document   : procesa_eliminar
    Created on : 09-ene-2019, 17:11:37
    Author     : SYSTEMarket-pc
--%>

<%@page import="ReglasDeNegocio.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
try {
       boolean result =Proveedor.proveedor_eliminar(Integer.valueOf(request.getParameter("codigo")));
        if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

       
    } catch (Exception e) {
        out.print(e.toString());
    }
%>
