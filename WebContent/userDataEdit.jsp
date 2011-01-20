
<html>

<head>

<title>Benutzerdaten editieren</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script src="js/jquery.min.1.4.2.js" type="text/javascript"></script>
<script src="js/jquery-easing.1.2.js" type="text/javascript"></script>
<script src="js/jquery-easing-compatibility.1.2.js"
	type="text/javascript"></script>
<script src="js/coda-slider.1.1.1.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="css/register.css" />

<script type="text/javascript">
	jQuery(window).bind("load", function() {
		jQuery("div#slider1").codaSlider()
	});
</script>

</head>

<body>
<%
	String sUserid = request.getParameter("userid");
	String sFirstname = request.getParameter("firstname");
	String sLastname = request.getParameter("lastname");
	String sStreet = request.getParameter("street");
	String sZip = request.getParameter("zip");
	String sPlace = request.getParameter("place");
	String sEmail = request.getParameter("email");
	String sHnr = request.getParameter("hnr");
%>


<noscript>
<p>Unfortunately your browser does not hava JavaScript capabilities
which are required to exploit full functionality of our site. This could
be the result of two possible scenarios:</p>
<ol>
	<li>You are using an old web browser, in which case you should
	upgrade it to a newer version. We recommend the latest version of <a
		href="http://www.getfirefox.com">Firefox</a>.</li>
	<li>You have disabled JavaScript in you browser, in which case you
	will have to enable it to properly use our site. <a
		href="http://www.google.com/support/bin/answer.py?answer=23852">Information
	on enabling JavaScript</a>.</li>
</ol>
</noscript>

<div class="slider-wrap">
<div id="slider1" class="csw">
<div class="panelContainer">
<div class="panel" title="Benutzer">
<div class="wrapper">
<h3>Benutzer</h3>
<form>
<table border="0">
	<tr>
		<td>Kundennummer</td>
		<td>
		<%
			request.getParameter("userid");
		%>
		</td>
	</tr>
	<tr>
		<td>Vorname</td>
		<td><input class="textfield" name="firstname" type="text"
			maxlength="30" value=<%= sFirstname%>></td>
	</tr>
	<tr>
		<td>Nachname</td>
		<td><input class="textfield" name="lastname" type="text"
			maxlength="30" value=<%= sLastname%>></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input class="textfield" name="email" type="text"
			maxlength="30" value=<%= sEmail %>></td>
	</tr>
</table>
</form>
<p><a href="#2" class="cross-link" title="Adresse">Nächste
&#187;</a></p>
</div>
</div>
<div class="panel" title="Adresse">
<div class="wrapper">
<h3>Adresse</h3>
<form action="index.jsp">
<table border="0">
	<tr>
		<td>Straße</td>
		<td><input class="textfield" name="street" type="text"
			maxlength="30" value=<%= sStreet%>></td>
	</tr>
	<tr>
		<td>Hausnummer</td>
		<td><input class="textfield" name="hnr" type="text"
			maxlength="30" value=<%= sHnr%>></td>
	</tr>
	<tr>
		<td>PLZ</td>
		<td><input class="textfield" name="zip" type="text"
			maxlength="30" value=<%= sZip%>></td>
	</tr>
	<tr>
		<td>Ort</td>
		<td><input class="textfield" name="place" type="text"
			maxlength="30" value=<%= sPlace%>></td>
	</tr>
</table>
<div class="register-buttons"><input class="button" type="submit"
	value=""> <a class="button" href="userDataView.jsp"><img
	src="images/main/cancel.png" width="103" height="42" /></a></div>
</form>
<p><a href="#2" class="cross-link" title="Adresse">&#171;
Vorherige</a></p>
</div>
</div>

</div>
</div>
</div>



</body>

</html>