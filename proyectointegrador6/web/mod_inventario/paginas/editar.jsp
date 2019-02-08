<%@page import="ReglasDeNegocio.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Sg_pagina sg_paginas= new Sg_pagina();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         sg_paginas=Sg_pagina.sg_pagina_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pagina</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=sg_paginas.getPaginaid()%>">
              <input type="text" required class="form-control" placeholder="Url Pagina" id="url" value="<%=sg_paginas.getUrl()%>" name="url"/>
              <input type="text" required class="form-control" placeholder="Descripcion" id="descripcion" value="<%=sg_paginas.getDescripcion()%>" name="descripcion"/>
          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>