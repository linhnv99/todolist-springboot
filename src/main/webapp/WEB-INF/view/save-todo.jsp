<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-title">
	<span>${isAdd ? 'Add' : 'Edit'} task</span>
	<button type="button" style="outline: none;" class="close"
		data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<form action="" class="custom-form add-todo">
	<div class="modal-body">
		<c:if test="${!isAdd }">
			<input type="hidden" name="id" value="${todo.id }">
		</c:if>
		<div class="form-group">
			<label for="todoName">Todo Name: <small class="text-danger">*</small></label>
			<input type="text" name="name" id="name" value="${!isAdd ? todo.name : '' }">
		</div>
		<div class="form-group">
			<label for="todoDesc">Description: <small class="text-danger">*</small></label>
			<textarea name="description" id="desc" cols="10" rows="3">${!isAdd ? todo.description : '' }</textarea>
		</div>
		<div class="form-group">
			<label for="">Priority: <small class="text-danger">*</small></label>
			<select name="priority">
				<option value="0" ${(!isAdd) && todo.priority == 0 ? 'selected' : '' }>Normal</option>
				<option value="1" ${(!isAdd) && todo.priority == 1 ? 'selected' : '' }>Medium</option>
				<option value="2" ${(!isAdd) && todo.priority == 2 ? 'selected' : '' }>High</option>
			</select>
		</div>
		<div class="form-group">
			<label for="todoDue">Due: <small class="text-danger">*</small></label>
			<input type="datetime-local" name="due" id="due" value="${!isAdd ? todo.due : '' }">
		</div>
	</div>
	<div class="modal-bot text-right">
		<button type="button" class="button" onclick="saveTodo()">${isAdd ? 'Add' : 'Save'} task</button>
	</div>
</form>