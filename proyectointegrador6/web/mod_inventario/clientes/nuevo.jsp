

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='validar.js'></script>
        <title>Nuevo Cliente</title>
        
    </head>
    <body>         
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombres Cliente" required id="nombres_cliente" name="nombres_cliente"/>            
            <input type="text" class="form-control" placeholder="Apellidos Cliente" required id="apellidos_cliente" name="apellidos_cliente"/>
            <input type="text" class="form-control" placeholder="Telefono Cliente" required id="telefono_cliente" name="telefono_cliente"/>
            <input type="text" class="form-control" placeholder="Email Cliente" required id="email_cliente" name="email_cliente"/>
                   <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-info" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>

