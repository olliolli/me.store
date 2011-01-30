<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Login</title>

		<link href="css/login.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div style="padding: 0px 0 0 157px;">
			<form method="post" action="Login" name="frmLogin">
				<div id="login-box">
					<H2>Login</H2>
					<br />
					<br />
					
					<div id="login-box-name" style="margin-top:20px;">Email:</div>
					<div id="login-box-field" style="margin-top:20px;">
						<input name="username" class="form-login" title="Username" value="" size="30" maxlength="2048" />
					</div>
					<div id="login-box-name">Passwort:</div>
					<div id="login-box-field">
						<input name="password" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" />
					</div>
					
					<br />
					<span class="login-box-options">
						<a href="Register">Neukunde?</a>
						<!-- <a href="NewPassword">Passwort vergessen?</a> -->
					</span>
					<br />
					
					<br />
					<div class="login-box-buttons">
						<a href="javascript: document.frmLogin.submit();"><img src="images/login/login-btn_lightblue.png" width="103" height="42"/></a>
						<a href="javascript: history.back();"><img src="images/main/cancel.png" width="103" height="42" /></a>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
