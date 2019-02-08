<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>

<!DOCTYPE html>

<%
    try {
            Producto producto=new Producto();
            producto.setNombreproducto(request.getParameter("nombre_producto"));
            producto.setStock(Integer.valueOf(request.getParameter("Stock")));
             Categoria categoria = new Categoria();
            Categoria categorias = categoria.categoria_buscarporid(Integer.valueOf(request.getParameter("id_categoria")));
            producto.setCategoria(categorias);   
           boolean result= Producto.producto_insertar(producto);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");
        } catch (Exception e) {
            out.print(e.getMessage());
        }

%>




