function getJsonFromData(data){
	var json = {};
	for(item of data){
		json[item.name] = item.value;
	}
	return json;
}
function checkEmpty(){
	if($("#name").val().trim() == ""){
		$("#name").attr("style", "border: 1px solid red");return false;
	}else $("#name").removeAttr("style");
	if($("#desc").val().trim() == ""){
		$("#desc").attr("style", "border: 1px solid red");return false;
	}else $("#desc").removeAttr("style");
	if($("#due").val().trim() == ""){
		$("#due").attr("style", "border: 1px solid red");return false;
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
	if(confirm("Bạn có chắc chắn muốn xóa khỏi thùng rác? (Lưu ý: không thể khôi phục lại).")){
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

function pushInTrash(id, act){
	var cfm;
	if(act == 'restoreFromTrash')
		cfm = confirm("Bạn có chắc chắn muốn khôi phục?");
	else 
		cfm = confirm("Bạn có chắc chắn muốn đưa vào thùng rác?");
	
	if(cfm){
		$.ajax({
			url: "/api/put-in-trash/"+id,
			type: "PUT",
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
	$("#home-todo-view").load(location.origin+"/home-todo-viewer");
	$("#bin-todo-view").load(location.origin+"/bin-todo-viewer");
}

function validSignUp(){
	$input = $(".form-signup input");
	$pass = $("#user-pass");
	$repeatPass = $("#user-repeatpass");
	$errMess = $("#errMess");
	c = false;
	for(i = 0; i < $input.length; i++){
		if($input[i].value.trim() == ''){
			$input[i].style = 'border: 1px solid red';
			c = true;
		}else {
			$input[i].style = 'border: none';
		}
	}
	if(c) return false;
	if($pass.val() != $repeatPass.val()){
		$errMess.html("Xác nhận mật khẩu không khớp.Thử lại!");
		return false;
	}else {
		$errMess.html('');
	}
	return true;
}

function validateEmail(sEmail) {
	var filter = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	if (filter.test(sEmail)) {
		return true;
	} else {
		return false;
	}
}

$(document).ready(function () {
	todoViewer();
	$("#signup").on("click", function(){
		var data = $("form.form-signup").serializeArray();
		if(!validSignUp()) return;
		$.ajax({
			url: "/signup",
			type: "POST",
			data: JSON.stringify(getJsonFromData(data)),
			contentType: "application/json",
			dataType: "json",
			success: function(response){
				console.log(response)
				if(response.message == 'EMAIL_EXISTS'){
					$("#errMess").html("Email đã tồn tại. Vui lòng nhập email khác!");
				}else {
					window.location = "/login";
				}
			},
			error: function(err){
				console.log(err.err);
			}
		})
	})
	
	
	$("#forgetPassword").on("click", function(){
		var data = $("form.form-reset").serializeArray();
		var ipEmail = $("form.form-reset input").val().trim();
		if(ipEmail == ''){
			alert("Vui lòng nhập email đăng kí tài khoản của bạn.");
			return;
		}
		if(!validateEmail(ipEmail)){
			alert("Email không đúng định dạng. Thử lại!");
			return;
		}
		$(".lds-ellipsis").show();
		$.ajax({
			url: "/forget-password",
			type: "POST",
			data: JSON.stringify(getJsonFromData(data)),
			contentType: "application/json",
			dataType: "json",
			success: function(response){
				if(response.message == 'EMAIL_NO_EXISTS'){
					alert("Email không tồn tại. Vui lòng nhập lại!");
				}else {
					alert("Kiểm tra email của bạn để thay đổi mật khẩu.");
					window.location = "/login";
				}
				$(".lds-ellipsis").hide();
			},
			error: function(err){
				console.log(err.err);
			}
		})
	})
	
	$("form.form-cfm-password").on("submit", function(e){
		e.preventDefault();
		var ipPass = $("form.form-cfm-password input[type='password']").val().trim();
		var data = $("form.form-cfm-password").serializeArray();
		console.log(data)
		if(ipPass == ''){
			alert("Mật khẩu không được để trống");
			return;
		}
		
		$.ajax({
			url: "/confirm-reset",
			type: "POST",
			data: JSON.stringify(getJsonFromData(data)),
			contentType: "application/json;charset=utf-8",
			dataType: "json",
			success: function(response){
				console.log(response)
				window.location = "/login";
			},
			error: function(err){
				console.log(err.err);
			}
		})
	})
});