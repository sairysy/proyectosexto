

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
         try {
            Paginas paginas=new Paginas();
            paginas.setUrl(request.getParameter("url_paginas"));
            paginas.setDescripcion(request.getParameter("descripcion_paginas"));
           
           boolean result= Paginas.paginas_insertar(paginas);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                 out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

  
 %>
