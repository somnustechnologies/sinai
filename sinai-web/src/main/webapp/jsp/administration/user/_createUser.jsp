<%@ include file="/jsp/common/_pageHeaders.jsp"%>

<form:form  title="Agregar" modelAttribute="newMasterUser" id="newMasterUserForm" class="styledModalForm custom[width:450]" target="ajax:result" action="usersAdministration/createUser.do">
   <table>
        <tr height="25px">
           <td align="left">Nombre: </td>
           <td><form:input path="user.name" cssClass="mediumInput validate[required,custom[onlyLetterSp]]" /></td>
           
        </tr>
        <tr height="25px">
           <td align="left">Apellido Paterno</td>
           <td><form:input path="user.lastName" name="user.lastName" id="user.lastName" cssClass="mediumInput validate[required,custom[onlyLetterSp]]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Apellido Materno</td>
           <td><form:input path="user.middleName" cssClass="mediumInput validate[required,custom[onlyLetterSp]]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Correo Electronico: </td>
           <td><form:input path="user.mail" cssClass="mediumInput validate[required,custom[email]]"/></td>
        </tr>
        <tr height="25px">
           <td align="left">Nombre de Usuario: </td>
           <td><form:input path="credential.nickName" cssClass="mediumInput validate[required,minSize[8],maxSize[8]]"/></td>
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
        <tr height="25px">
           <td></td>
           <td align="right"><form:checkbox path="credential.locked"/> <span class ="litleLabel">Bloqueado</span></td>
        </tr>
        <tr height="50px">
	       <td colspan="2">
	           <button class="litleButton styledButton"  style="float:left" type="button" onclick="closeModalForm('newMasterUserForm')">Cancelar</button>
	           <button class="litleButton styledButton" style="float:right" type="submit">Guardar</button>
	       </td>
        </tr>
   </table>
</form:form>