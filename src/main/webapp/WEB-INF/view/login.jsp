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
<style>
	input{margin-bottom: 10px!important;}
</style>
<body>
     <div id="logreg-forms">
          <form class="form-signin" action="/login-page" method="post">
               <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
               <div class="social-login">
                    <button class="btn facebook-btn social-btn"><span><i class="fab fa-facebook-f"></i>
                              Sign in with Facebook</span> </button>
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i>
                              Sign in with Google+</span> </button>
               </div>
               <p style="text-align:center"> OR </p>
               <c:if test="${param.error }">
               	<p class="text-danger">Tài khoản hoặc mật khẩu không đúng.</p>
               </c:if>
               <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required=""
                    autofocus="">
               <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">

               <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign
                    in</button>
               <a href="#" id="forgot_pswd">Forgot password?</a>
               <hr>
               <!-- <p>Don't have an account!</p>  -->
               <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i>
                    Sign up New Account</button>
          </form>

          <form action="/forger-password" class="form-reset">
			<div class="lds-ellipsis">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
			<input type="email" name="email" id="resetEmail" class="form-control" placeholder="Email address" required=""
                    autofocus="">
               <button class="btn btn-primary btn-block" type="button" id="forgetPassword">Reset Password</button>
               <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
          </form>

          <form class="form-signup" action="/signup">
               <div class="social-login">
                    <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i>
                              Sign up with Facebook</span> </button>
               </div>
               <div class="social-login">
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i>
                              Sign up with Google+</span> </button>
               </div>

               <p style="text-align:center">OR</p>
				<p class="text-danger" id="errMess"></p>
               <input type="text" id="user-name" class="form-control" placeholder="Full name" name="name" required="" autofocus="">
               <input type="email" id="user-email" class="form-control" placeholder="Email address"  name="email" required
                    autofocus="">
               <input type="password" id="user-pass" class="form-control" placeholder="Password" name="password" required autofocus="">
               <input type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required
                    autofocus="">

               <button class="btn btn-primary btn-block" type="button" id="signup">Sign Up</button>
               <a href="#" id="cancel_signup">Back</a>
          </form>
          <br>

     </div>

</body>
<c:import url="/WEB-INF/view/layout/js.jsp"></c:import>
<script>
     function toggleResetPswd(e) {
          e.preventDefault();
          $('#logreg-forms .form-signin').toggle() // display:block or none
          $('#logreg-forms .form-reset').toggle() // display:block or none
     }

     function toggleSignUp(e) {
          e.preventDefault();
          $('#logreg-forms .form-signin').toggle(); // display:block or none
          $('#logreg-forms .form-signup').toggle(); // display:block or none
     }

     $(() => {
          // Login Register Form
          $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
          $('#logreg-forms #cancel_reset').click(toggleResetPswd);
          $('#logreg-forms #btn-signup').click(toggleSignUp);
          $('#logreg-forms #cancel_signup').click(toggleSignUp);
     })
</script>

</html>