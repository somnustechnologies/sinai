/*****************************************************************************/
/*****************************************************************************/
/*
 * inicializador
 */
function _init(){
	validate();
	stylize();
	setHandlers();
	$( "#tabs" ).tabs();
}

/*
 * destructor
 */
function _destroy(){
  $(".ui-dialog-content").remove();
  $('#noDisplayArea').validationEngine('hideAll');
}

/*****************************************************************************/
/*****************************************************************************/
/*
 * Inicializa los validadores para lso formularios
 * - Los Forms deben ser de la clase validableForm
 */
function validate(){
	var validableForms = $(".validableForm");
	for(var i=0;i<validableForms.length;i++){
		$(validableForms[i]).validationEngine();
	}
}

function hideValidations(){
	$('#noDisplayArea').validationEngine('hideAll');
}

/*****************************************************************************/
/*****************************************************************************/

function setHandlers(){
	setAjaxHandlers();
	setInputToUpperHandlers();
}

function setAjaxHandlers(){
	var forms = $("form");	 
	var target;
	for(var i=0;i<forms.length;i++){
      target = $(forms[i]).attr("target");
      if(target != undefined) {
	    if(target.indexOf("ajax:")==0){
		   $(forms[i]).unbind();
		   $(forms[i]).submit(function() {
			  if($(this).validationEngine('validate')){
				  var targetArea = "#" + ($(this).attr("target").substring(5)); 
				  $(targetArea).html('<div class="loader"><img src="/Munae/img/loader.gif" /></div>');
				  $(targetArea).load($(this).attr("action"), $(this).serialize());
				  if($(this).hasClass("ui-dialog-content")){
					  closeModalForm($(this).attr("id"));
					  _destroy();
				  }
			  }
			  return false;
		    });
		  }
        }
	}
}

function setInputToUpperHandlers(){
	var textInputs = $(':text');
	for(var i=0;i<textInputs.length;i++){
		if(! $(textInputs[i]).hasClass("noUpper")){
		    $(textInputs[i]).keypress( function(){ 
			                              var key = window.event.keyCode;
			                              if ((key > 0x60) && (key < 0x7B)) {
			                                   window.event.keyCode = key-0x20;
			                           }});
	   }  
	}
}
/*****************************************************************************/
/*****************************************************************************/
/*
 * Inicializador de los parametros generales para las tablas jqGrid
 */

jQuery.extend(jQuery.jgrid.defaults, { altRows:true,
	                                   pager: '#pager',
                                       viewrecords: true,
                                       height:230,
                                       sortname: 'id',
                                       rownumbers: false,
                                       sortorder: "desc",
                                       multiselect: true,
                                       multiboxonly: true,
                                       rowNum:10,
                                       scrollOffset:0,
                                       onSelectRow: function (rowId) {
                                    	  if($("#uniqueSelectedId") != undefined){
                                    		 $("#uniqueSelectedId").val(rowId);
                                    	  }
                                       }});

/*****************************************************************************/
/*****************************************************************************/
/*
 * Funciones para aplicar los estilos JQUERY UI (jqGrid) de forma automatica
 * - Las tablas deben ser de la clase styledTable
 * - Los botones deben ser de las siguientes clases dependiendo del tipo:
 *   * styledButton
 *   * styledSearchButton
 *   * styledDeleteButton
 * 
 * */

function stylize(){
	stylizeModalConfirmation();
	stylizeModalForm();
	stylizeTabModalForm();
	stylizeButtons();
	stylizeTables();
}

function stylizeTables(){
  var styledTables = $(".styledTable");
  for(var i=0;i<styledTables.length;i++){
    if($(styledTables[i]).attr("id") == undefined){
      $(styledTables[i]).attr("id","styledTable" + i);
    }
    if($(styledTables[i]).attr("title") == undefined){
      $(styledTables[i]).attr("title","Datos");
    }
    tableName = "#" + $(styledTables[i]).attr("id");
    fixTableEmptyHeaders();
    tableToGrid(tableName,{
      caption : $(styledTables[i]).attr("title")
    });  
    jQuery(tableName).jqGrid('setGridParam', {page: 1}).trigger("reloadGrid");
    $(styledTables[i]).removeClass("styledTable");
    $(styledTables[i]).addClass("dataTable");
}
	
}

function stylizeButtons(){
  $( ".styledButton").button();
}

function stylizeModalConfirmation() {
	var styledConfirmation = $(".stylizedModalConfirmation");
	for(var i=0;i<styledConfirmation.length;i++){
		$(styledConfirmation[i]).dialog({ autoOpen: true,
			                              resizable: false,
			                              height:140,
			                              closeOnEscape:true,
			                              dialogClass:"modalConfirmation",
			                              draggable: false,
			                              modal: true
		                                });
	  $(styledConfirmation[i]).removeClass("stylizedModalConfirmation");
	}
}

function stylizeModalForm() {
	var styledModalForm = $(".styledModalForm");
	for(var i=0;i<styledModalForm.length;i++){
		$(styledModalForm[i]).dialog({ autoOpen: true,
			                           width: getCustomParam($(styledModalForm[i]).attr("class"), "width"),
 			                           height: 'auto',
		                               closeOnEscape:true,
		                               dialogClass:"modalForm",
		                               draggable: false,
		                               modal: true
		                             });
	  $(styledModalForm[i]).removeClass("styledModalForm");
	}
}

function getCustomParam(cssClass, param){
   var custom, entries;
   if(cssClass.indexOf("custom[") != -1){
	   custom = cssClass.substring(cssClass.indexOf("custom[") + 7);
	   custom = custom.substring(0, custom.indexOf("]"));
	   if(custom.indexOf(param) != -1){
		   entries = custom.split(":");
		   for(var i=0;i<entries.length;i++){
			   if(entries[i] == param){
				   return entries[i + 1];
			   }
		   }
	   }
   }
}

function stylizeTabModalForm() {
	var stylizeTabModalForm = $(".styledTabModalForm");
	for(var i=0;i<stylizeTabModalForm.length;i++){
		$(stylizeTabModalForm[i]).dialog({ autoOpen: true,
 			                           height: 'auto',
 			                           width: '700px',
		                               closeOnEscape:true,
		                               dialogClass:"modalForm",
		                               draggable: false,
		                               modal: true,
		                               open: function (event, ui) {
		                            	   $(stylizeTabModalForm[i]).css('overflow', 'hidden');
		                               }
		                             });
	  $(stylizeTabModalForm[i]).removeClass("stylizeTabModalForm");
	}
}

function stylizeMessages (){
	var styledMessage = $(".messageArea");
	for(var i=0;i<styledMessage.length;i++){
		$(styledMessage[i]).addClass("ui-icon ui-icon-inf");
		$(styledMessage[i]).removeClass("messageArea");
	}
}

function fixTableEmptyHeaders(){
	var th = $("tr th");
	var spaces ;
	for(var i=0;i<th.length;i++){
		if($(th[i]).html() == ""){
			spaces = "";
			for(var j=0;j<=i;j++){
				spaces = spaces + "&nbsp;";
			}
			$(th[i]).html(spaces);
		}
	}
}
/*****************************************************************************/
/*****************************************************************************/

function getSelectedRows(tableName){
	var idTable = $($('table[title^="' + tableName + '"]')).attr("id");
	if(idTable == undefined){
		throw "Table not found for title " + tableName;
	}
	return jQuery("#" + idTable).jqGrid('getGridParam','selarrrow').toString();
}

function loadModalForm(url, params){
	_destroy();
	$("#noDisplayArea").load(url,params);
}

function loadModalConfirmation(url, params){
	_destroy();
	$("#noDisplayArea").load(url,params);
}

function loadContent(url, aid){
	_destroy();
	$('#content').html('<div class="loader"><img src="/Munae/img/page_loader.gif" /></div>');
	$("#content").load(url,{aid: aid}, function(response, status, xhr) {
		  if (status == "error") {
		    $("#content").load("error/pageNotFound.do",{errMsg: xhr.statusText});
		  }
		});
}

function load(url, containterId){
	$('#' + containterId).html('<div class="loader"><img src="/Munae/img/page_loader.gif" /></div>');
	$('#' + containterId).load(url,{}, function(response, status, xhr) {
		  if (status == "error") {
		    $("#content").load("error/pageNotFound.do",{errMsg: xhr.statusText});
		  }
		});
}

function proccessModalForm(form, action, target){
  if($("#" + form).validationEngine('validate')){
	if(target==undefined){
      target="noDisplayArea";
	}
    $("#" + target).load(action,$("#" + form).serialize());
    $("#" + form).dialog("close");
    _destroy();
  }
}

function closeModalForm(form){
	$("#" + form).dialog("close");
	$("#noDisplayArea").validationEngine("hideAll");
}

function hideMessages(){
	if($(".messageArea") != undefined){
		$(".messageArea").html("");
	}
}

function printMessage(message, error) {
	$(".messageArea").load("jsp/common/_frontMessage.jsp", {infMessage:message, errMessage:error});
}

function actionConfirmed(url,target,params, modalConfirmation){
	$("#" + target).load(url,params);
	$("#" + modalConfirmation).dialog("close");
	$(".modalConfirmation").remove();
}
