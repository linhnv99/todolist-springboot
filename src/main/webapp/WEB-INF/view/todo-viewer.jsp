<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${todos }" var="todo">
	<li class="list-group-item"><c:choose>
			<c:when test="${todo.priority == 0}">
				<div class="todo-indicator bg-warning"></div>
			</c:when>
			<c:when test="${todo.priority == 1 }">
				<div class="todo-indicator bg-success"></div>
			</c:when>
			<c:otherwise>
				<div class="todo-indicator bg-danger"></div>
			</c:otherwise>
		</c:choose>
		<div class="widget-content p-0">
			<div class="widget-content-wrapper">
				<div class="widget-content-left mr-2">
					<c:if test="${!bin }">
						<div class="custom-checkbox custom-control ">
							<input class="custom-control-input js-checkbox"
								id="checkbox${todo.id }" type="checkbox"
								onclick="toggleCompleted(${todo.id})"
								${todo.completeStatus ? 'checked' : '' }> <label
								class="custom-control-label" for="checkbox${todo.id }">&nbsp;</label>
						</div>
					</c:if>
				</div>
				<div class="widget-content-left">
					<div
						class="widget-heading ${todo.completeStatus ? 'line-through' : '' }">${todo.name }</div>
					<div class="widget-subheading">
						<div class="${todo.completeStatus ? 'line-through' : '' }">
							Due: ${todo.due }
							<c:if test="${todo.late }">
								<div class="badge badge-pill badge-danger ml-2">Lated</div>
							</c:if>
							<c:if test="${todo.completeStatus }">
								<div class="badge badge-pill badge-success ml-2">Completed</div>
							</c:if>
						</div>
					</div>
				</div>
				<div class="widget-content-right " style="position: relative;">
					<div class="glyph-icon flaticon-settings js-ctrlSet"></div>
					<div class="control-setting">
						<c:choose>
							<c:when test="${bin }">
								<a href="javascript:void(0)" class="editTodo"
									onclick="pushInTrash(${todo.id}, 'restoreFromTrash')"><i
									class="mr-2 glyph-icon flaticon-edit text-success"></i>Khôi phục</a>
								<a href="javascript:void(0)" onclick="deleteTodo(${todo.id})"><i
									class="mr-2 glyph-icon flaticon-delete text-danger"></i>Xóa</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0)" class="editTodo"
									onclick="editTodo(${todo.id})"><i
									class="mr-2 glyph-icon flaticon-edit text-success"></i>Sửa</a>
								<a href="javascript:void(0)" onclick="pushInTrash(${todo.id}, 'pushInTrash')"><i
									class="mr-2 glyph-icon flaticon-delete text-danger"></i>Xóa</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div></li>
</c:forEach>
<c:if test="${todos.size()== 0 }">
	<li class=" mt-2">Danh sách rỗng</li>
</c:if>
<script>
	$(function(){
	     $(".js-ctrlSet").on("click", function(){
	          $(this).next().toggle();
	     })
	     // checkbox
     	 $(".js-checkbox").on("click", function(){
         if($(this).is(":checked")){
              $(this).parent().parent().next().find("div").addClass("line-through");
         }else {
              $(this).parent().parent().next().find("div").removeClass("line-through");
         }
         console.log($(this))
     	})
	})
</script>