<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${todos }" var="todo">
	<li class="list-group-item">
		<c:choose>
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
					<div class="custom-checkbox custom-control ">
						<input class="custom-control-input js-checkbox" id="checkbox${todo.id }"
							type="checkbox"><label class="custom-control-label"
							for="checkbox${todo.id }">&nbsp;</label>
					</div>
				</div>
				<div class="widget-content-left">
					<div class="widget-heading">${todo.name }</div>
					<div class="widget-subheading">
						<div>
							${todo.due }
							<div class="badge badge-pill badge-info ml-2">NEW</div>
						</div>
					</div>
				</div>
				<div class="widget-content-right " style="position: relative;">
					<div class="glyph-icon flaticon-settings js-ctrlSet"></div>
					<div class="control-setting">
						<a href="#"><i
							class="mr-2 glyph-icon flaticon-search text-primary"></i>Chi tiết</a>
						<a href="#"><i
							class="mr-2 glyph-icon flaticon-edit text-success"></i>Sửa</a> <a
							href="#"><i
							class="mr-2 glyph-icon flaticon-delete text-danger"></i>Xóa</a>
					</div>
				</div>
			</div>
		</div>
	</li>
</c:forEach>

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