

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
         try {
            Cliente cliente=new Cliente();
            cliente.setNombres(request.getParameter("nombre_cliente"));
            cliente.setApellidos(request.getParameter("apellido_cliente"));
            cliente.setTelefono(request.getParameter("telefono_cliente"));
            cliente.setEmail(request.getParameter("email_cliente"));
           boolean result= Cliente.cliente_insertar(cliente);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                 out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }

  
 %>
