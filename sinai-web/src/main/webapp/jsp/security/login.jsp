<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type"
    content="text/html; charset=iso-8859-1" />
    <title>Munae</title>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link href="${pageContext.request.contextPath}/css/jquery-ui-custom.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/jquery-validationEngine.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/jquery-ui-jqgrid.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/master.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-1.6.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.validationEngine-es.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.validationEngine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.jqGrid.locale-es.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/util.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/validations.js"></script>
  </head>
  <body>
   <div class="container">
    <div style="padding: 100px 0 0 250px;">
    <form:form modelAttribute="userCredential" id="signupForm" cssClass="validableForm" action="singUp.do">
      ${errorMessage}
      <div id="login-box">
         <h2>MUNAE</h2>Registro de Obra
         <br/><br/>
         <table>
              <tr>
                 <td>
                    <div id="login-box-name" style="margin-top:20px;">Usuario:</div>
                 </td>
                 <td>
                   <div id="login-box-field" style="margin-top:20px;">
                       <form:input path="nickName" id="nickName" cssClass="validate[required] form-login" size="30" maxlength="20" />
                   </div>                 
                 </td>
              </tr>
              <tr>
                 <td>
                   <div id="login-box-name" style="margin-top:10px;">Password:</div>
                 </td>
                 <td>
                   <div id="login-box-field" style="margin-top:10px;">
                    <form:password path="password" id="password" cssClass="validate[required] form-login" size="30" maxlength="8" />
                   </div>
                 </td>
              </tr>
              <tr>
                 <td colspan="2">
                    <input style="float:right" type="submit" style="margin-left:90px;" value="Entrar"/>
                 </td>
              </tr>
         </table>
         
	  </div>
	  </form:form>
    </div>
    </div>
  </body>
</html>

<script type="text/javascript">
   $(document).ready(init());
   
   function init(){
	 _init();
	 printMessage("<%=request.getAttribute("infMessage")%>"
	              ,"<%=request.getAttribute("errMessage")%>");
   }
</script>