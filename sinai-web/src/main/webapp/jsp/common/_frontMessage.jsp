<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test='${not empty param.infMessage}'>
  <c:if test='${param.infMessage ne "null"}'>
     <div class="ui-state-highlight ui-corner-all frontMessage">
         <span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
         ${param.infMessage}
     </div>
   </c:if>
</c:if>

<c:if test='${not empty param.errMessage}'>
  <c:if test='${param.errMessage ne "null"}'>
     <div class="ui-state-error ui-corner-all frontMessage">
         <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
         ${param.errMessage}
     </div>
   </c:if>
</c:if>