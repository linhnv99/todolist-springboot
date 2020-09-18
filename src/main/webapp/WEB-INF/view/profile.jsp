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
               <div class="content" id="profile">
                    <!-- <h1 class="title">
                         Profile <span class="today"></span>
                    </h1> -->
                    <div class="view-content">
                         <div class="inner-content">
                              <div class="row">
                                   <div class="col-12 col-md-5">
                                        <div class="box-avatar">
                                             <div class="vien"><span class="avatar" style="background-image: url(images/avatar.jpg);"></span></div>
                                             <h1>Nguyễn Viết Linh</h1>
                                        </div>
                                   </div>
                                   <div class="col-12 col-md-7">
                                        <div class="box-info">
                                             <p><span>Name:</span>Nguyễn Viết Linh</p>
                                             <p><span>Gender: </span> Man</p>
                                             <p><span>Phone:</span>0986613124</p>
                                             <p><span>Email: </span>nvlk12haui@gmail.com</p>
                                             <div class="social">
                                                  <span>Social:</span>
                                                  <a href=""><i class="glyph-icon flaticon-facebook"></i></a>
                                                  <a href=""><i class="glyph-icon flaticon-github"></i></a>
                                                  <a href=""><i class="glyph-icon flaticon-twitter"></i></a>
                                             </div>
                                        </div>
                                   </div>
                              </div>
                              <div class="row">
                                   <div class="col-12">
                                        <div class="box-gt">
                                             <div class="title">Giới thiệu bản thân</div>
                                             <div>
                                                  Lorem ipsum dolor sit, amet consectetur adipisicing elit. Voluptatibus quam eligendi, doloremque repellat animi
                                                  accusamus provident sint quasi harum sapiente sed officia? Esse rem officiis voluptates iusto laudantium quis fuga!
                                             </div>
                                        </div>
                                   </div>
                              </div>
                         </div>
                    </div>
               </div>
          </div>
          
     </div>
</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>