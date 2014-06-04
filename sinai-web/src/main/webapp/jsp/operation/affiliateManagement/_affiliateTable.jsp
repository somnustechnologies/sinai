<%@ include file="/jsp/common/_pageHeaders.jsp"%>

<script type="text/javascript">
   function showEditUserInformation(userId){
	 loadModalForm("usersAdministration/setupUpdateUserInformation.do",{userId:userId});
   }
</script>

<table class="styledTable" title="AFILIADOS"> 
  <thead> 
    <tr> 
      <th width="3%">
        <input type="checkbox"/>
      </th> 
      <th width="50px">No.</th> 
	  <th width="400px">NOMBRE C0MPLETO</th> 
	  <th width="25%">LUGAR DE NACIMIENTO</th>
	  <th width="25%">FECHA DE NACIMIENTO</th>  
	  <th>SEXO</th>
	  <th>EDAD</th>
	  <th>PERTENENCIA ETNICA</th>
	  <th>DOMICILIO</th>
	  <th>COLONIA</th>
	  <th>CURP</th>
	  <th>TIEMPO DE RESIDENCIA</th>
	  <th>OCUPACION</th>
	  <th>ULTIMO GRADO DE ESTUDIOS</th>    
   </tr> 
  </thead> 
  <tbody> 
      <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>25847</td>
		<td>FERNANDO RIVERA CALDERON</td>
		<td>DISTRITO FEDERAL</td>
		<td>01/01/1980</td>
		<td>H</td>
		<td>18 AÑOS</td>
		<td>HUICHOL</td>
		<td>CALLE 5 NUMERO 8</td>
		<td>NUEVA AMPLIACION</td>
		<td>CABD850625ML1</td>
		<td>3 AÑOS</td>
		<td>OBRERO</td>
		<td>PREPARATORIA</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>258347</td>
		<td>SALVADOR GOMEZ BRAVO</td>
		<td>ESTADO DE MEXICO</td>
		<td>23/12/1992</td>
		<td>H</td>
		<td>30 AÑOS</td>
		<td>N/A</td>
		<td>CALLE 7 CIENEGAS</td>
		<td>IMPULSORA</td>
		<td>DFRT850625ML1</td>
		<td>1 AÑOS</td>
		<td>EMPLEADO</td>
		<td>PREPARATORIA</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>28746</td>
		<td>SOPHIA HERNANDEZ BECERRIL</td>
		<td>JALISCO</td>
		<td>05/06/1970</td>
		<td>M</td>
		<td>84 AÑOS</td>
		<td>N/A</td>
		<td>ORIENTE 1234</td>
		<td>NUEVA VALLEJO</td>
		<td>JGHY850625ML1</td>
		<td>10 AÑOS</td>
		<td>MEDICO CIRUJANO</td>
		<td>DOCTORADO</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>98563</td>
		<td>SANTIAGO CASTILLO BERMUDEZ</td>
		<td>DISTRITO FEDERAL</td>
		<td>15/05/1995</td>
		<td>H</td>
		<td>19 AÑOS</td>
		<td>/N/A</td>
		<td>ESCALERILLAS 10</td>
		<td>METROPOLITANA</td>
		<td>KIUY850625ML1</td>
		<td>0 AÑOS</td>
		<td>PROFESOR</td>
		<td>MAESTRIA</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>69875</td>
		<td>DIEGO HERNANDEZ BECERRIL</td>
		<td>JALISCO</td>
		<td>08/06/1980</td>
		<td>H</td>
		<td>23 AÑOS</td>
		<td>TZOLZIL</td>
		<td>PRESA LA ANGOSTURA 345</td>
		<td>POLANCO</td>
		<td>LKSG850625ML1</td>
		<td>62 AÑOS</td>
		<td>PROFESIONISTA</td>
		<td>LICENCIATURA</td>
	  </tr>
      <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>25847</td>
		<td>FERNANDO RIVERA CALDERON</td>
		<td>DISTRITO FEDERAL</td>
		<td>01/01/1980</td>
		<td>H</td>
		<td>18 AÑOS</td>
		<td>HUICHOL</td>
		<td>CALLE 5 NUMERO 8</td>
		<td>NUEVA AMPLIACION</td>
		<td>CABD850625ML1</td>
		<td>3 AÑOS</td>
		<td>OBRERO</td>
		<td>PREPARATORIA</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>258347</td>
		<td>SALVADOR GOMEZ BRAVO</td>
		<td>ESTADO DE MEXICO</td>
		<td>23/12/1992</td>
		<td>H</td>
		<td>30 AÑOS</td>
		<td>N/A</td>
		<td>CALLE 7 CIENEGAS</td>
		<td>IMPULSORA</td>
		<td>DFRT850625ML1</td>
		<td>1 AÑOS</td>
		<td>EMPLEADO</td>
		<td>PREPARATORIA</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>28746</td>
		<td>SOPHIA HERNANDEZ BECERRIL</td>
		<td>JALISCO</td>
		<td>05/06/1970</td>
		<td>M</td>
		<td>84 AÑOS</td>
		<td>N/A</td>
		<td>ORIENTE 1234</td>
		<td>NUEVA VALLEJO</td>
		<td>JGHY850625ML1</td>
		<td>10 AÑOS</td>
		<td>MEDICO CIRUJANO</td>
		<td>DOCTORADO</td>
	  </tr>
	  <tr>
        <td><input type="checkbox" value ="1"/></td>
        <td>98563</td>
		<td>SANTIAGO CASTILLO BERMUDEZ</td>
		<td>DISTRITO FEDERAL</td>
		<td>15/05/1995</td>
		<td>H</td>
		<td>19 AÑOS</td>
		<td>/N/A</td>
		<td>ESCALERILLAS 10</td>
		<td>METROPOLITANA</td>
		<td>KIUY850625ML1</td>
		<td>0 AÑOS</td>
		<td>PROFESOR</td>
		<td>MAESTRIA</td>
	  </tr>
  </tbody> 
</table> 
<div id="pager"></div>
