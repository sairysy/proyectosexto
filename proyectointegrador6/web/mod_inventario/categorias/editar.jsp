<%@page import="ReglasDeNegocio.Categoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Categoria categoria= new Categoria();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         categoria=Categoria.categoria_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Categoria</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=categoria.getCategoriaid()%>">
              <input type="text" required class="form-control" placeholder="Nombre Categoria" id="nombre" value="<%=categoria.getNombre()%>" name="nombre"/>
              <input type="text" required class="form-control" placeholder="Descripcion Categoria" id="descripcion" value="<%=categoria.getDescripcion()%>" name="descripcion"/>
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>

