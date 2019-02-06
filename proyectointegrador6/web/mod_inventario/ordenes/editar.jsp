<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Proveedores> lista= Proveedores.proveedores_buscartodos();
 Iterator<Proveedores> itProveedores=lista.iterator();
%>
<%
 List<Producto> listap= Producto.producto_buscartodos();
 Iterator<Producto> itProducto=listap.iterator();
%>


<%!
   Ordenes ordenes= new Ordenes();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         ordenes=Ordenes.ordenes_buscarporid(codigo);                       
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Venta</title>
     
    </head>
    
    <body>                    
          <form method="POST" action="procesa_editar.jsp">
          <input type="hidden" id="codigo" name="codigo" value="<%=ordenes.getOrdenid()%>">  
          
          <select required class="form-control" placeholder="Proveedorid Proveedor" id="proveedorid" value="<%=ordenes.getProveedores()%>"  name="proveedorid">
          
            <%while(itProveedores.hasNext()){
                Proveedores proveedores=itProveedores.next();%> %>
            <option value="<%=proveedores.getProveedorid()%>"><%=proveedores.getNombreproveedor()%></option>
            <% } %>
                                  
            </select>
            <select required class="form-control" placeholder="Productoid Producto" id="productoid" value="<%=ordenes.getProducto()%>" name="productoid">              
          
            <%while(itProducto.hasNext()){
                Producto producto=itProducto.next();%> %>
            <option value="<%=producto.getProductoid()%>"><%=producto.getNombreproducto()%></option>
            <% } %>                             
            </select>
          <input type="text" required class="form-control" placeholder="Cantidad Ordenes" id="cantidad_ordenes" value="<%=ordenes.getCantidad()%>" name="cantidad_ordenes"/>
          <input type="text" required class="form-control" placeholder="Preciounitario Ordenes" id="preciounitario_ordenes" value="<%=ordenes.getPreciounitario()%>" name="preciounitario_ordenes"/>
          <input type="text" required class="form-control" placeholder="Numeroorden Ordenes" id="numeroorden_ordenes" value="<%=ordenes.getNumeroorden()%>" name="numeroorden_ordenes"/>
          <input type="text" required class="form-control" placeholder="Entregada Ordenes" id="entrega_ordenes" value="<%=ordenes.getEntregada()%>" name="entrega_ordenes"/>
         <input type="text" required class="form-control" placeholder="Fechaentrega Ordenes" id="fechaentrega_ordenes" value="<%=ordenes.getFechaentrega()%>" name="fechaentrega_ordenes"/>
     
          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>