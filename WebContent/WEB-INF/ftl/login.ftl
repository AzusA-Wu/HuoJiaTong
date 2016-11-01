<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="assets/login/css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<!--//webfonts-->
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<!--SIGN UP-->
	<h1>${name}</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="assets/login/images/avtar.png" />
		</div>
		<!-- <form action="login_by_username" method="post"> -->
			<input id="account" type="text" class="text"
				value="Username" onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}">
			<div class="key">
				<input id="password" type="password" onfocus="this.value = '';">
			</div>
		<!-- </form> -->
		<div class="signin">
			<input id="IbtnEnter" type="submit" value="Login">
		</div>
	</div>
	<div class="copy-rights">
		<p>Copyright &copy; 2016.Lolita All rights reserved.</p>
	</div>
<script type="text/javascript" src="assets/login/js/login.js"></script>
</body>
</html>