<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Sistema Integral de Administracion Iztacalco</title>
      <%@ include file="/jsp/common/_includes.jsp"%>
      <%@ include file="/jsp/common/_pageHeaders.jsp"%>
      
   </head>
   <body onclick="hideMessages()">
      <div class="container">
         <div class="header">
           <%@ include file="/jsp/layout/_header.jsp"%>
         </div>
         <div class="menu">
           <%@ include file="/jsp/layout/_menu.jsp" %>
         </div>
         <div class="content" id="content">
            <%@ include file="/jsp/security/welcome.jsp"%>
         </div>
         <div class="footer">
           <%@ include file="/jsp/layout/_footer.jsp"%>
         </div>
         
      </div>
      <div id="noDisplayArea" style="display:none"></div>
   </body>
</html>