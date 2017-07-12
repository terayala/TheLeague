function updateAccount() {
	event.preventDefault();
	var queryString = " ";
	var formData = $("#AccountForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status!="success"){
			document.alert("INVALID REQUEST");
		} 
	});
}