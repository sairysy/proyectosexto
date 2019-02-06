

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
    try {
            Proveedores proveedores=new Proveedores();
            proveedores.setNombreproveedor(request.getParameter("nombreproveedor_proveedores"));
            proveedores.setDireccion(request.getParameter("direccion_proveedores"));
            proveedores.setTelefefono(request.getParameter("telefono_proveedores"));
            proveedores.setProveedorid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Proveedores.proveedores_editar(proveedores);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>