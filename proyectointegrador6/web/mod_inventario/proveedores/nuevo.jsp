

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='validar.js'></script>
        <title>Nuevo Proveedor</title>
        
    </head>
    <body>         
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombre Proveedor" required id="nombre_proveedor" name="nombre_proveedor"/>            
            <input type="text" class="form-control" placeholder="Direccion Proveedor" required id="direccion_proveedor" name="direccion_proveedor"/>
            <input type="text" class="form-control" placeholder="Telefono Proveedor" required id="telefono_proveedor" name="telefono_proveedor"/>
                   <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>

