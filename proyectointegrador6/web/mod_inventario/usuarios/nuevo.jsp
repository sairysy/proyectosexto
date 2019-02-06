

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        
          <form method="POST"  action="procesa_nuevo.jsp">
            <input type="text" class="form-control" placeholder="Nombre_usuario Usuarios" required id="nombre_usuario_Usuarios" name="nombre_usuario_Usuarios"/>
             <input type="text" class="form-control" placeholder="Contrasenia Usuarios" required id="contrasenia_Usuarios" name="contrasenia_Usuarios"/>
             <input type="text" class="form-control" placeholder="Cedula Usuarios" required id="cedula_Usuarios" name="cedula_Usuarios"/>
             
            
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
    </body>
</html>
