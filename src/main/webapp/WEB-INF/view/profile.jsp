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
									<div class="vien">
										<c:if test="${user.avatar != null }">
											<span class="avatar"
											style="background-image: url(${path}/files/${user.avatar });"></span>
										</c:if>
										<c:if test="${user.avatar == null }">
											<span class="avatar"
											style="background-image: url(${path}/images/user.png);"></span>
										</c:if>
									</div>
									<h1>${user.name }</h1>
								</div>
							</div>
							<div class="col-12 col-md-7">
								<div class="box-info">
									<p>
										<span>Name:</span>${user.name }</p>
									<p>
										<span>Gender: </span>${user.gender == 0 ? 'Nam' : user.gender == 1 ? 'Nữ' :'Khác' }</p>
									<p>
										<span>Phone:</span>${user.phone }</p>
									<p>
										<span>Email: </span>${user.email }</p>
									<p>
										<span>Address: </span>${user.address }</p>
									<div class="social">
										<span>Social:</span> <a href="${user.fbLink }"><i
											class="glyph-icon flaticon-facebook"></i></a> <a
											href="${user.githubLink }"><i
											class="glyph-icon flaticon-github"></i></a> <a
											href="${user.twitterLink }"><i
											class="glyph-icon flaticon-twitter"></i></a>
									</div>
								</div>
							</div>
						</div>
						<c:if test="${user.introYourself.trim() != ''  }">
							<div class="row">
								<div class="col-12">
									<div class="box-gt">
										<div class="title">Giới thiệu bản thân</div>
										<div>${user.introYourself }</div>
									</div>
								</div>
							</div>
						</c:if>
						<a href="${path }/edit-profile"
							class="btn btn-secondary text-white float-right d-inline-block mt-4">Edit</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>