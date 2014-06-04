<%@ include file="/jsp/common/_pageHeaders.jsp"%>

<script type="text/javascript">
  function showDeleteUsers(){
    if(getSelectedRows("USUARIOS") != ""){
	  loadModalConfirmation("usersAdministration/setupDeleteUser.do");
	}
  }
   
   function showCreateUser(){
	   loadModalForm("usersAdministration/setupCreateUser.do");
   }
   
   function selectCriteria(){
	   hideValidations();
	   $("#textValue").val("");
	   $("#selectValue").val("");
	   if($("#criteriaType").val()==4){
		   $('#textValue').attr('disabled', 'disabled');
		   $('#selectValue').removeAttr('disabled');
		   $("#textValue").hide();
		   $("#selectValue").show();
	   } else{
		   $('#selectValue').attr('disabled', 'disabled');
		   $('#textValue').removeAttr('disabled');
		   $("#textValue").show();
		   $("#selectValue").hide();
	   }
   }
   
   </script>

<div id="pageContent" class="pageContent">
  <div id ="pageTitle" class="pageTitle">Padrón de Afiliados</div>
  <div class="messageArea"></div>
  <div id="searchArea" class="searchArea">
     <form:form modelAttribute="searchParams" id="searchUsersForm" target="ajax:result" action="affiliateManagement/search.do">
         <table class="fullWidthTable">
              <tr>
                 <td class="label">
                   Busqueda por:
                 </td>
                 <td>
                    <form:select path="criteriaType" id="criteriaType" cssClass="validate[funcCall[requiredIf[textValue]], funcCall[requiredIf[selectValue]]] selectBox" onchange="selectCriteria()">
                        <form:option value="">SELECCIONE</form:option>
                        <form:option value="">Nombre</form:option>
                        <form:option value="">Colonia</form:option>
                    </form:select>
                 </td>
                 <td>
                    <form:input path="criteriaValue" id="textValue" cssClass="validate[funcCall[requiredIf[criteriaType]]] bigInput" />
                 </td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td align="left">
                    <form:checkbox path="onlyLocked"></form:checkbox>
                    <span class ="litleLabel">Solo activos</span>
                </td>
              </tr>
              <tr>
                 <td colspan="3" align="right">
                    <button class="button styledButton" type="submit">Buscar</button>
                 </td>
              </tr>
         </table>
      </form:form>
  </div>
  <div id="result" class="result">
<%--      <%@ include file="/jsp/administration/user/_userTable.jsp"%> --%>
  </div>
  <div >
    <table class="fullWidthTable">
          <tr>
             <td align="left"><button class="button styledButton" type="button" onclick="showDeleteUsers()">Eliminar</button></td>
             <td align="right"><button class="button styledButton" type="button" onclick="showCreateUser()">Nuevo</button></td>
          </tr>
    </table>
  </div>
</div>
