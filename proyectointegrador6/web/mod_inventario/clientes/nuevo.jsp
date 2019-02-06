

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombre Cliente" required id="nombre_cliente_cliente" name="nombre_cliente"/>
             <input type="text" class="form-control" placeholder="Apellido Cliente" required id="apellido_cliente" name="apellido_cliente"/>
             <input type="text" class="form-control" placeholder="Telefono Cliente" required id="telefono_cliente" name="telefono_cliente"/>
             <input type="text" class="form-control" placeholder="Email Cliente" required id="email_cliente" name="email_cliente"/>
            
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
