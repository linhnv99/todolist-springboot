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

function editTodo(id){
	$("#saveTodo").load(location.origin + "/edit-todo/"+ id);
	$("#saveModal").modal("show");
}
function addTodo(){
	$("#saveTodo").load(location.origin + "/add-todo");
	$("#saveModal").modal("show");
}
function deleteTodo(id){
	if(confirm("Bạn có chắc chắn muốn xóa?")){
		$.ajax({
			url: "/api/delete-todo/"+id,
			type: "DELETE",
			dataType: "json",
			success: function(response){
				if(response.status){
					todoViewer();
				}
			},
			error: function(err){
				console.log(err);
			}
		})
	}
}

function saveTodo(){
	if(!checkEmpty()) return;
	var data = $("form.add-todo").serializeArray();
	console.log(getJsonFromData(data));
	$.ajax({
		url: "/api/save-todo",
		type: "POST",
		data: JSON.stringify(getJsonFromData(data)),
		contentType: "application/json",
		dataType: "json",
		success: function(response){
			if(response.status){
				todoViewer();
				$("input[type='text']").val("");
				$("textarea").val("");
				$("#saveModal").modal("hide");
			}
		},
		error: function(err){
			console.log(err);
		}
	})
}

function toggleCompleted(id){
	$.ajax({
		url: "/api/completed/"+id,
		type: "POST",
		dataType: "json",
		success: function(response){
			if(response.status){
				todoViewer();
			}
		},
		error: function(err){
			console.log(err);
		}
	})
}

var todoViewer = () =>{
	$("#todo-view").load(location.origin + "/todo-viewer");
}
$(document).ready(function () {
	todoViewer();
});