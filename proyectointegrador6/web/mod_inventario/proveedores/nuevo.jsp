

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombreproveedor Proveedores" required id="nombreproveedor_proveedores" name="nombreproveedor_proveedores"/>
             <input type="text" class="form-control" placeholder="Direccion Proveedores" required id="direccion_proveedores" name="direccion_proveedores"/>
             <input type="text" class="form-control" placeholder="Telefono Proveedores" required id="telefono_proveedores" name="telefono_proveedores"/>
            
            
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
