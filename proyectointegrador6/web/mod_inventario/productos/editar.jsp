<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 List<Categoria> lista= Categoria.categoria_buscartodos();
 Iterator<Categoria> itCategoria=lista.iterator();
%>
<%!
   Producto producto= new Producto();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         producto=Producto.producto_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=producto.getProductoid()%>">
              <input type="text" required class="form-control" placeholder="Nombre Producto" id="nombre_producto" value="<%=producto.getNombreproducto()%>" name="nombre_producto"/>
               <input type="text" required class="form-control" placeholder="Stock" id="Stock" value="<%=producto.getStock()%>" name="Stock"/>
              <select required class="form-control" placeholder="Id Categoria" id="id_categoria" value="<%=producto.getCategoria()%>"  name="id_categoria">          
            <%while(itCategoria.hasNext()){
                Categoria categoria=itCategoria.next();%> %>
            <option value="<%=categoria.getCategoriaid()%>"><%=categoria.getNombre()%></option>
            <% } %>
          </select>
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>

