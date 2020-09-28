<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					Today <span class="today"></span>
				</h1>
				<div class="view-content">
					<div class="inner-content">
						<ul class=" list-group list-group-flush" id="home-todo-view">


						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" style="z-index: 99999; padding: 0;"
			id="saveModal" tabindex="-1" aria-labelledby="saveModal"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" id="saveTodo"></div>
			</div>
		</div>
		<!-- /Modal -->
	</div>
</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>
