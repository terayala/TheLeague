function updateAccount() {
	event.preventDefault();
	var queryString = "http://52.14.91.142:8080/LeagueCommissioner/updateuser";
	var formData = $("#AccountForm").serialize();
	$.post(queryString, formData).done( function(data, status){
		if(status!="success"){
			document.alert("INVALID REQUEST");
		} 
	});
}