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
					<div class="view-content">
						<div class="inner-content">
							<h4 class="mb-5 mt-4 mt-md-0">Edit profile</h4>
							<form:form action="/save-profile" enctype="multipart/form-data" class="custom-form"
							modelAttribute="user" method="POST">
								<c:if test="${isEdit }">
									<form:hidden path="id"/>
								</c:if>
								<div class="row">
									<div class="col-12 col-md-7">
										<div class="form-group">
											<label for="">Name: </label> <form:input type="text" path="name" />
										</div>
										<div class="form-group">
											<label for="">Gender: </label> 
											<form:select path="gender">
												<form:option value="0">Nam</form:option>
												<form:option value="1">Nữ</form:option>
												<form:option value="2">Khác</form:option>
											</form:select>
										</div>
										<div class="form-group">
											<label for="">Phone: </label> <form:input type="text" path="phone"/>
										</div>
										<div class="form-group">
											<label for="">Address: </label> <form:input type="text" path="address"/>
										</div>
										<div class="form-group">
											<label for="">Facebook Link: </label> <form:input type="text" path="fbLink"/>
										</div>
										<div class="form-group">
											<label for="">Github Link: </label> <form:input type="text" path="githubLink"/>
										</div>
										<div class="form-group">
											<label for="">Twitter Link: </label> <form:input type="text" path="twitterLink"/>
										</div>
									</div>
									<div class="col-12 col-md-5">
										<div class="form-group">
											<div class="file-upload">
												<button class="file-upload-btn" type="button"
													onclick="$('.file-upload-input').trigger( 'click' )">Add
													Avatar</button>

												<div class="image-upload-wrap">
													<input class="file-upload-input" type='file'
														onchange="readURL(this);" accept="image/*" name="imgAvatar"/>
													<div class="drag-text">
														<h3>Drag and drop a file or select add Image</h3>
													</div>
												</div>
												<div class="file-upload-content">
													<img class="file-upload-image" src="#" alt="your image" />
													<div class="image-title-wrap">
														<button type="button" onclick="removeUpload()"
															class="remove-image">
															Remove <span class="image-title">Uploaded Image</span>
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-12">
										<p style="font-size: 16px;">Giới thiệu bản thân</p>
										<div class="form-group">
											<form:textarea name="intro" id="intro" cols="" rows="5"
												style="width: 100%;" path="introYourself" />
										</div>
									</div>
								</div>
								<div class="btn-group float-right mb-5">
									<button class="btn btn-primary mr-2">Save</button>
									<a href="" class="btn btn-secondary text-white">Cancel</a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>