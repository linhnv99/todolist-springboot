function getJsonFromData(data){
	var json = {};
	for(item of data){
		json[item.name] = item.value;
	}
	return json;
}
function checkEmpty(){
	if($("#name").val().trim() == ""){
		$("#name").attr("style", "border: 1px solid red");
	}else $("#name").removeAttr("style");
	if($("#desc").val().trim() == ""){
		$("#desc").attr("style", "border: 1px solid red");
	}else $("#desc").removeAttr("style");
	if($("#due").val().trim() == ""){
		$("#due").attr("style", "border: 1px solid red");
	}else $("#due").removeAttr("style");
	return true;
}


var todoViewer = () =>{
	$("#todo-view").load(location.origin + "/todo-viewer");
}
$(document).ready(function () {
	todoViewer();
    $("#addTodo").on("click", function(){
    	if(!checkEmpty()) return;
    	var data = $("form.add-todo").serializeArray();
    	console.log(getJsonFromData(data));
    	$.ajax({
    		url: "/api/add-todo",
    		type: "POST",
    		data: JSON.stringify(getJsonFromData(data)),
    		contentType: "application/json",
    		dataType: "json",
    		success: function(response){
    			if(response.status){
    				todoViewer();
    				$("input[type='text']").val("");
    				$("#addModal").modal("hide");
    			}
    		},
    		error: function(err){
    			console.log(err);
    		}
    	})
    })
});