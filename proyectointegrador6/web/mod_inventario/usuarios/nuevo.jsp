<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
        
    </head>
    <body>         
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombre Usuario" required id="nombre_usuario" name="nombre_usuario"/>            
            <input type="text" class="form-control" placeholder="Contrasenia" required id="contrasenia" name="contrasenia"/>
            <input type="text" class="form-control" placeholder="Identificacion" required id="identificacion" name="identificacion"/>
                   <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
