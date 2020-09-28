<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="position: fixed; width: 100%;z-index: 9999;">
     <div class="top-menu">
          <div class="left">
               <span class="button-group" id="js-menu" data-status="close">
                    <span></span>
                    <span></span>
                    <span></span>
               </span>
               <a href="#" class="text-white">
                    <i class="glyph-icon flaticon-home"></i>
               </a>
               <!-- <a href="#" class="text-white">
                    <i class="glyph-icon flaticon-add-1"></i>
               </a> -->
               <form action="" class="form-search" id="js-form-search">
                    <input type="text" placeholder="Tìm kiếm">
                    <div class="glyph-icon flaticon-search"></div>
               </form>
          </div>
          <div class="right">
               <div class="user">
                    <span class="user-image">
                         <c:choose>
                         	<c:when test="${user.avatar != null }">
                         		<img src="${path }/files/${user.avatar}" alt="">
                         	</c:when>
                         	<c:otherwise>
                         		<img src="${path }/images/user.png" alt="">
                         	</c:otherwise>
                         </c:choose>
                    </span>
                    <span class="ml-1 user-name">
                    	${user.name }
                    </span>
               </div>
          </div>
     </div>
</div>