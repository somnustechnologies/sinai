function requiredIf(field, rules, i, options){
   if($("#" + rules[i+2]).val()!=""){
	   if(field.val()==""){
		  return options.allrules.required.alertText;
	   }
   }
}