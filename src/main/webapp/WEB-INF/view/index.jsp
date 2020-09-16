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
                              <ul class=" list-group list-group-flush">
                                   <li class="list-group-item">
                                        <div class="todo-indicator bg-warning"></div>
                                        <div class="widget-content p-0">
                                             <div class="widget-content-wrapper">
                                                  <div class="widget-content-left mr-2">
                                                       <div class="custom-checkbox custom-control "> <input
                                                                 class="custom-control-input js-checkbox" id="checkbox1"
                                                                 type="checkbox"><label class="custom-control-label"
                                                                 for="checkbox1">&nbsp;</label> </div>
                                                  </div>
                                                  <div class="widget-content-left">
                                                       <div class="widget-heading">Call Sam For payments <div
                                                                 class="badge badge-danger ml-2">Rejected
                                                            </div>
                                                       </div>
                                                       <div class="widget-subheading"><i>By Bob</i></div>
                                                  </div>
                                                  <div class="widget-content-right " style="position: relative;">
                                                       <div class="glyph-icon flaticon-settings js-ctrlSet"> </div>
                                                       <div class="control-setting">
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-search text-primary"></i>Chi
                                                                 tiết</a>
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-edit text-success"></i>Sửa</a>
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-delete text-danger"></i>Xóa</a>
                                                       </div>
                                                  </div>
                                             </div>
                                        </div>
                                   </li>
                                   <li class="list-group-item">
                                        <div class="todo-indicator bg-success"></div>
                                        <div class="widget-content p-0">
                                             <div class="widget-content-wrapper">
                                                  <div class="widget-content-left mr-2">
                                                       <div class="custom-checkbox custom-control "><input
                                                                 class="custom-control-input js-checkbox" id="checkbox2"
                                                                 type="checkbox"><label class="custom-control-label"
                                                                 for="checkbox2">&nbsp;</label></div>
                                                  </div>
                                                  <div class="widget-content-left">
                                                       <div class="widget-heading">Make payment to Bluedart</div>
                                                       <div class="widget-subheading">
                                                            <div>By Johnny <div
                                                                      class="badge badge-pill badge-info ml-2">NEW</div>
                                                            </div>
                                                       </div>
                                                  </div>
                                                  <div class="widget-content-right " style="position: relative;">
                                                       <div class="glyph-icon flaticon-settings js-ctrlSet"> </div>
                                                       <div class="control-setting">
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-search text-primary"></i>Chi
                                                                 tiết</a>
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-edit text-success"></i>Sửa</a>
                                                            <a href="#"><i
                                                                      class="mr-2 glyph-icon flaticon-delete text-danger"></i>Xóa</a>
                                                       </div>
                                                  </div>
                                             </div>
                                        </div>
                                   </li>

                              </ul>
                              <a href="javascript(0)" data-toggle="modal" data-target="#exampleModal" class="add-task">
                                   <i class="mr-2 glyph-icon flaticon-plus"></i>Add task</a>
                         </div>
                    </div>
               </div>
          </div>
          <!-- Modal -->
          <div class="modal fade" style="z-index: 99999;padding: 0;" id="exampleModal" tabindex="-1"
               aria-labelledby="exampleModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                    <form action="" class="custom-form">
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
                                        <label for="">Todo Name: <small class="text-danger">*</small></label>
                                        <input type="text">
                                   </div>
                                   <div class="form-group">
                                        <label for="">Description: <small class="text-danger">*</small></label>
                                        <textarea name="" id="" cols="10" rows="3"></textarea>
                                   </div>
                                   <div class="form-group">
                                        <label for="">Priority: <small class="text-danger">*</small></label>
                                        <select name="" id="">
                                             <option value="">Normal</option>
                                             <option value="">Medium</option>
                                             <option value="">High</option>
                                        </select>
                                   </div>
                                   <div class="form-group">
                                        <label for="">Due: <small class="text-danger">*</small></label>
                                        <input type="date">
                                   </div>
                              </div>
                              <div class="modal-bot text-right">
                                   <button type="submit" class="button">Add task</button>
                              </div>
                         </div>
                    </form>
               </div>
          </div>
     </div>
</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>