<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Sg_rol sg_roles= new Sg_rol();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         sg_roles =Sg_rol.sg_rol_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Rol</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=sg_roles.getRolid()%>">
              <input type="text" required class="form-control" placeholder="Nombre Rol" id="nombre_ro" value="<%=sg_roles.getNombre_rol()%>" name="nombre_rol"/>
              <input type="text" required class="form-control" placeholder="Descripcion" id="decripcion_roles" value="<%=sg_roles.getDescripcion()%>" name="descripcion"/>               
              <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>                  
    </body>    
</html>