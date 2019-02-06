<%-- 
    Document   : editar
    Created on : 09/01/2019, 17:27:36
    Author     : sairy
--%>
<%@page import="ReglasDeNegocio.Paginas"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
   Paginas paginas= new Paginas();
%>
<%
    try {
        
         int codigo= Integer.parseInt(request.getParameter("codigo"));
      //  out.print("<script>alert("+codigo+");</script>");
         paginas=Paginas.paginas_buscarporid(codigo);
        
        
        
        } catch (Exception e) {
        }
   
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Paginas</title>
     
    </head>
    
    <body>
       
        
        
          <form method="POST" action="procesa_editar.jsp">
              <input type="hidden" id="codigo" name="codigo" value="<%=paginas.getPaginaid()%>">
              <input type="text" required class="form-control" placeholder="Url Paginas" id="url_paginas" value="<%=paginas.getUrl()%>" name="url_paginas"/>
              <input type="text" required class="form-control" placeholder="Descripcion Paginas" id="descripcion_paginas" value="<%=paginas.getDescripcion()%>" name="descripcion_paginas"/>
          
          
            <div class="modal-footer">
                <button id="btn_guardar" name="btn_guardar" type="submit" class="btn btn-primary" >Guardar</button>
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
        </form>
          
        
    </body>
    
</html>