<%-- 
    Document   : editar
    Created on : 09/01/2019, 17:27:36
    Author     : sairy
--%>
<%@page import="ReglasDeNegocio.Proveedores"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Proveedores proveedores= new Proveedores();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         proveedores=Proveedores.proveedores_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Proveedores</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=proveedores.getProveedorid()%>">
              <input type="text" required class="form-control" placeholder="Nombreproveedor Proveedores" id="nombre_proveedores" value="<%=proveedores.getNombreproveedor()%>" name="nombreproveedor"/>
              <input type="text" required class="form-control" placeholder="Direccion Proveedores" id="nombre_proveedores" value="<%=proveedores.getDireccion()%>" name="direccion"/>
          <input type="text" required class="form-control" placeholder="Telefono Proveedores" id="nombre_proveedores" value="<%=proveedores.getTelefefono()%>" name="telefono"/>

          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>