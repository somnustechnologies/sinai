<%@ include file="/jsp/common/_pageHeaders.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>

<div class="applemenu">
   <c:forEach var="modules" items="${session.masterModules}" varStatus="moduleIndex">
      <div class="silverheader"><a href="#">${modules.module.name}</a></div>
      <div class="submenu">
          <c:forEach var="subModule" items="${modules.autorities}">
                 <div  class="opcionmenu"> <a title= "${subModule.description}" href="javascript:loadContent('${subModule.target}','${subModule.id}')">${subModule.name}</a></div>
          </c:forEach>
      </div>
   </c:forEach>
</div>
