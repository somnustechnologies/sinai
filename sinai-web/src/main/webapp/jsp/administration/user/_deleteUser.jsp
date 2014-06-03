<%@ include file="/jsp/common/_pageHeaders.jsp"%>

<script type="text/javascript">
   function removeUser(){
	   actionConfirmed("usersAdministration/deleteUsers.do","result"
		  ,{'chainIds':getSelectedRows("USUARIOS")}, "modalConfirmUsersDelete");
   }
</script>
	

<table id="modalConfirmUsersDelete" class=stylizedModalConfirmation title="Eliminar">
    <tr>
      <td colspan="2"> 
	      <span class="ui-icon ui-icon-alert" style="float:left;"></span>
	      Los usuarios seleccionados seran eliminados permanentemente. Desea continuar ?
	  </td>
	</tr>
	<tr>
      <td colspan="2">
         <br/> 
      </td>
    </tr>
	<tr>
	  <td><button class="litleButton styledButton" type="button" onclick="closeModalForm('modalConfirmUsersDelete')">Cancelar</button></td>
	  <td><button class="litleButton styledButton" type="button" onclick="removeUser()">Aceptar</button></td>
	</tr>
</table>