<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="side-bar" id="js-sidebar">
     <ul>
          <li class="active"><a href="${path }/"><i class="mr-2 glyph-icon flaticon-calendar"></i>Today</a></li>
          <li><a href="${path }/todo-list"><i class="mr-2 glyph-icon flaticon-calendar"></i>TodoList</a></li>
          <li><a href="${path }/profile"><i class="mr-2 glyph-icon flaticon-user"></i>Profile</a></li>
          <li><a href="#"><i class="mr-2 glyph-icon flaticon-group"></i>User</a></li>
          <li><a href="${path }/bin"><i class="mr-2 glyph-icon flaticon-delete"></i>Bin</a></li>
	      <sec:authorize access="isAuthenticated()">
	      	<li><a href="${path }/logout"><i class="mr-2 glyph-icon flaticon-logout"></i>Logout</a></li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('ROLE_ADMIN')">
	      	User Manager
	      </sec:authorize>
     </ul>
</div>
<div class="overlay" id="js-overlay"></div>