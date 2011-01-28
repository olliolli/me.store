<%
	String sMemberID = "'"+request.getAttribute("memberID").toString()+"'";
	String sFirstname = "'"+request.getAttribute("fname").toString()+"'";
	String sLastname = "'"+request.getAttribute("lname").toString()+"'";
	String sStreet = "'"+request.getAttribute("street").toString()+"'";
	String sZip = "'"+request.getAttribute("zip").toString()+"'";
	String sPlace = "'"+request.getAttribute("place").toString()+"'";
	String sEmail = "'"+request.getAttribute("email").toString()+"'";
	String sHnr = "'"+request.getAttribute("hnr").toString()+"'";
%>


<div id="content" style="padding-top: auto;">
	<form action="User?toModus=commit" method="post">	
		<div class="clearfix">
			<h3 class="yellow f14">Benutzer</h3>
		</div>	
		<div class="clearfix">
			<table border="0" class="userTable">
				<tr class="userRow">
					<td class="leftColumn">Kundennummer</td>
					<td class="rightColumn"><input class="textfield" name="memberID" type="text"
						maxlength="30" value=<%=sMemberID%> readonly></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Vorname</td>
					<td class="rightColumn"><input class="textfield" name="firstname" type="text"
						maxlength="30" value=<%=sFirstname%> readonly></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Nachname</td>
					<td class="rightColumn"><input class="textfield" name="lastname" type="text"
						maxlength="30" value=<%=sLastname%>></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Email</td>
					<td class="rightColumn"><input class="textfield" name="email" type="text"
						maxlength="30" value=<%=sEmail%>></td>
				</tr>
			</table>	
		</div>
		
		<div class="clearfix">
			<h3 class="yellow f14">Adresse</h3>
		</div>	
		<div class="clearfix">
			<table border="0" class="userTable">
				<tr class="userRow">
					<td class="leftColumn">Straﬂe</td>
					<td class="rightColumn"><input class="textfield" name="street" type="text"
						maxlength="30" value=<%=sStreet%>></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Hausnummer</td>
					<td class="rightColumn"><input class="textfield" name="hnr" type="text"
						maxlength="30" value=<%=sHnr%>></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">PLZ</td>
					<td class="rightColumn"><input class="textfield" name="zip" type="text"
						maxlength="30" value=<%=sZip%>></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Ort</td>
					<td class="rightColumn"><input class="textfield" name="place" type="text"
						maxlength="30" value=<%=sPlace%>></td>
				</tr>
			</table>
		</div>
		<div class="clearfix" style="margin-top: 16px;">
			<div class="register-buttons">
			<input class="resume-Button" type="submit" value=""> 
			<a href="User?toModus=view">
				<img src="images/main/cancel.png" width="103" height="42" />
			</a>
			</div>
		</div>
	</form>				
</div>
