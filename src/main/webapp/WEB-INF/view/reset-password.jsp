<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="vn">

<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Todo App</title>
</head>
<c:import url="/WEB-INF/view/layout/css.jsp"></c:import>
<style>
	input{margin-bottom: 10px!important;}
</style>
<body>
     <div id="logreg-forms">
          <form class="form-signin form-cfm-password" action="/confirm-reset" method="post">
               <h1 class="h3 mb-4 font-weight-normal" style="text-align: center">Reset Password</h1>
               <input type="hidden" value="${user.email }" name="email">
               <input type="password" name="password" class="form-control" placeholder="New password"
                    autofocus="">
               <button class="btn btn-success btn-block mb-4" id="cfm-reset-pasword" type="submit"><i class="fas fa-sign-in-alt"></i> Confirm</button>
          </form>
     </div>

</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
</html>