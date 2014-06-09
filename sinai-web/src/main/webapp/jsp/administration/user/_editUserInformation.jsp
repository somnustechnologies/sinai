<%@ include file="/jsp/layout/container/_pageHeaders.jsp"%>
<form:form modelAttribute="masterUser" id="modalFormEditUser" class="styledModalForm custom[width:450]" title="Editar" target="ajax:result" action="usersAdministration/updateUserInformation.do">
   <form:hidden path="user.id"/>
   <table>
        <tr height="25px">
           <td align="left">Nombre: </td>
           <td><form:input path="user.name" cssClass="mediumInput validate[required,custom[onlyLetterSp]]" /></td>
           
        </tr>
        <tr height="25px">
           <td align="left">Apellido Paterno</td>
           <td><form:input path="user.lastName" cssClass="mediumInput validate[required,custom[onlyLetterSp]]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Apellido Materno</td>
           <td><form:input path="user.middleName" cssClass="mediumInput validate[required]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Correo Electronico: </td>
           <td><form:input path="user.mail" cssClass="mediumInput validate[required,custom[email]]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Perfil: </td>
           <td>
              <form:select path="profile.id" class="mediumSelect validate[required]">
              <form:option value="">SELECCIONE</form:option>
                 <form:options items="${profiles}"  
                               itemValue="id"
                               itemLabel="name"/>
              </form:select>
           </td>
        </tr>
        <tr height="50px">
	       <td colspan="2">
	           <button class="litleButton styledButton"  style="float:left" type="button" onclick="closeModalForm('modalFormEditUser')">Cancelar</button>
	           <button class="litleButton styledButton" style="float:right" type="submit">Guardar</button>
	       </td>
        </tr>
   </table>
</form:form>