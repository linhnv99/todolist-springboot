<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="vn">

<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Todo App</title>
</head>
<c:import url="/WEB-INF/view/layout/css.jsp"></c:import>
<body>
     <div class="main">
          <!-- top-menu -->
          <c:import url="/WEB-INF/view/layout/top-menu.jsp"></c:import>
          <!-- /top-menu -->
          <div class="main-content">
               <!-- sidebar -->
               <c:import url="/WEB-INF/view/layout/sidebar.jsp"></c:import>
               <!-- /sidebar -->
               <div class="content">
                    <h1 class="title">
                         Today <span class="today">Thứ ba, 15/9</span>
                    </h1>
                    <div class="view-content">
                         <div class="inner-content">
                              <ul class=" list-group list-group-flush" id="todo-view">
                                   
                              </ul>
                              <a href="javascript(0)" data-toggle="modal" data-target="#addModal" class="add-task">
                                   <i class="mr-2 glyph-icon flaticon-plus"></i>Add task</a>
                         </div>
                    </div>
               </div>
          </div>
          <!-- Modal -->
          <div class="modal fade" style="z-index: 99999;padding: 0;" id="addModal" tabindex="-1"
               aria-labelledby="addModal" aria-hidden="true">
               <div class="modal-dialog">
                    <form action="" class="custom-form add-todo">
                         <div class="modal-content">
                              <div class="modal-title">
                                   <span>Add task</span>
                                   <button type="button" style="outline: none;" class="close" data-dismiss="modal"
                                        aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                   </button>
                              </div>
                              <div class="modal-body">
                                   <div class="form-group">
                                        <label for="todoName">Todo Name: <small class="text-danger">*</small></label>
                                        <input type="text" name="name" id="name">
                                   </div>
                                   <div class="form-group">
                                        <label for="todoDesc">Description: <small class="text-danger">*</small></label>
                                        <textarea name="description"  id="desc" cols="10" rows="3" ></textarea>
                                   </div>
                                   <div class="form-group">
                                        <label for="">Priority: <small class="text-danger">*</small></label>
                                        <select name="priority">
                                             <option value="0">Normal</option>
                                             <option value="1">Medium</option>
                                             <option value="2">High</option>
                                        </select>
                                   </div>
                                   <div class="form-group">
                                        <label for="todoDue">Due: <small class="text-danger">*</small></label>
                                        <input type="datetime-local" name="due" id="due">
                                   </div>
                              </div>
                              <div class="modal-bot text-right">
                                   <button type="button" class="button" id="addTodo">Add task</button>
                              </div>
                         </div>
                    </form>
               </div>
          </div>
     </div>
</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>
