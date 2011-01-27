
<html>

<head>

	<title>Registrierung</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<script src="js/jquery.min.1.4.2.js" type="text/javascript"></script>
	<script src="js/jquery-easing.1.2.js" type="text/javascript"></script>
	<script src="js/jquery-easing-compatibility.1.2.js" type="text/javascript"></script>
	<script src="js/coda-slider.1.1.1.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="css/register.css" />
	
	<script type="text/javascript">
		jQuery(window).bind("load", function() {
			jQuery("div#slider1").codaSlider()
		});
	</script>
		
</head>

<body>


	
<noscript>
	<p>Unfortunately your browser does not hava JavaScript capabilities which are required to exploit full functionality of our site. This could be the result of two possible scenarios:</p>
	<ol>
		<li>You are using an old web browser, in which case you should upgrade it to a newer version. We recommend the latest version of <a href="http://www.getfirefox.com">Firefox</a>.</li>
		<li>You have disabled JavaScript in you browser, in which case you will have to enable it to properly use our site. <a href="http://www.google.com/support/bin/answer.py?answer=23852">Information on enabling JavaScript</a>.</li>
	</ol>
</noscript>

<div class="slider-wrap">	
	<div id="slider1" class="csw">
		<div class="panelContainer">
			<div class="panel" title="Benutzer">
				<div class="wrapper">
					<h3>Benutzer</h3>
					<form action="Register" method="post">										
						<table border="0">
							<tr>
								<td>Vorname</td>
								<td><input class="textfield" name="firstname" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Nachname</td>
								<td><input class="textfield" name="lastname" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input class="textfield" name="email" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Passwort</td>
								<td><input class="textfield" name="password" type="password" maxlength="30"></td>
							</tr>
							<tr>
								<td>Passwort Wiederholung</td>
								<td><input class="textfield" name="w_password" type="password" maxlength="30"></td>
							</tr>
						</table>					
					<p> <a href="#2" class="cross-link" title="Lieferadresse">Nächste &#187;</a></p>
				
				</div>
			</div><!--
			<div class="panel" title="Lieferadresse">
				<div class="wrapper">
					<h3>Lieferadresse</h3>
					<form>
						<table border="0">
							<tr>
								<td>Vorname</td>
								<td><input class="textfield" name="l_first_name" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Nachname</td>
								<td><input class="textfield" name="l_last_name" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Straße</td>
								<td><input class="textfield" name="l_street" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Hausnummer</td>
								<td><input class="textfield" name="l_hnr" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>PLZ</td>
								<td><input class="textfield" name="l_zip" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Ort</td>
								<td><input class="textfield" name="l_place" type="text" maxlength="30"></td>
							</tr>
						</table>
					</form>
					<p><a href="#1" class="cross-link" title="Benutzer">&#171; Vorherige</a> | <a href="#3" class="cross-link" title="Rechnungsadresse">Nächste &#187;</a></p>
				</div>
			</div>		
	--><div class="panel" title="Adresse">
				<div class="wrapper">
					<h3>Adresse</h3>													
						<table border="0">
							<tr>
								<td>Straße</td>
								<td><input class="textfield" name="r_street" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Hausnummer</td>
								<td><input class="textfield" name="r_hnr" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>PLZ</td>
								<td><input class="textfield" name="r_zip" type="text" maxlength="30"></td>
							</tr>
							<tr>
								<td>Ort</td>
								<td><input class="textfield" name="r_place" type="text" maxlength="30"></td>
							</tr>
						</table>
						<div class="register-buttons">
							<input class="button" type="submit" value="">	
							<a class="button" href="Login"><img src="images/main/cancel.png" width="103" height="42" /></a>
						</div>	
					<p><a href="Login" class="cross-link" title="Adresse">&#171; Vorherige</a> </p>
				</form>
				</div>	
				</div>
			</div>			
		</div>
	</div>				
</body>

</html>