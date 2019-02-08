

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,ReglasDeNegocio.*"%>
<!DOCTYPE html>
<%
    try {
            Sg_pagina sg_paginas=new Sg_pagina();
            sg_paginas.setUrl(request.getParameter("url"));
            sg_paginas.setDescripcion(request.getParameter("descripcion"));
            sg_paginas.setPaginaid(Integer.valueOf(request.getParameter("codigo")));
           boolean result= Sg_pagina.sg_pagina_editar(sg_paginas);
             if (result)
                out.println("<script> location.replace('listar.jsp?alerta=si');</script>");
            else 
                out.println("<script> location.replace('listar.jsp?alerta=no');</script>");

        } catch (Exception e) {
            out.print(e.getMessage());
        }
%>