
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AccesoADatos.*"%>
<%
 List<Proveedores> lista= Proveedores.proveedores_buscartodos();
 Iterator<Proveedores> itProveedores=lista.iterator();
%>

<%
 List<Producto> listap= Producto.producto_buscartodos();
 Iterator<Producto> itProducto=listap.iterator();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Venta</title>
        
    </head>
    <body>        
            <form method="POST"  action="procesa_nuevo.jsp">
           
            <select class="form-control" placeholder="proveedorid" required id="proveedoresid" name="proveedorid">  
            <option>Proveedores</option>
            <%while(itProveedores.hasNext()){
                Proveedores proveedores=itProveedores.next();%> %>
                <option value="<%=proveedores.getProveedorid()%>"><%=proveedores.getNombreproveedor()%></option>
            <% } %>                             
            </select>
            </select>
            <select  class="form-control" placeholder="Productoid" required id="id_producto" name="productoid">  
            <option>Producto</option>
            <%while(itProducto.hasNext()){
                Producto producto=itProducto.next();%> %>
            <option value="<%=producto.getProductoid()%>"><%=producto.getNombreproducto()%></option>
            <% } %>                             
            </select>    
            <input type="text" class="form-control" placeholder="Cantidad Orden" required id="cantidad_producto" name="cantidad_orden"/>
            <input type="text" class="form-control" placeholder="Preciounitario Orden" required id="preciounitario_producto" name="preciounitario_orden"/>            
             <input type="text" class="form-control" placeholder="Numeroorden Orden" required id="numeroorden_producto" name="numeroorden_orden"/>
            <input type="text" class="form-control" placeholder="Entredada Orden" required id="entregada_producto" name="entregada_orden"/>   
             <input type="text" class="form-control" placeholder="Fechaentrega Orden" required id="fechaentrega_producto" name="fechaentrega_orden"/>
        
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>