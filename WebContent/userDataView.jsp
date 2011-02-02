

<%
	String sMemberID = request.getAttribute("memberID").toString();
	String sFirstname = request.getAttribute("fname").toString();
	String sLastname = request.getAttribute("lname").toString();
	String sStreet = request.getAttribute("street").toString();
	String sZip = request.getAttribute("zip").toString();
	String sPlace = request.getAttribute("place").toString();
	String sEmail = request.getAttribute("email").toString();
	String sHnr = request.getAttribute("hnr").toString();
%>	

<div id="content" style="padding-top: auto;">
		<%
				if (request.getAttribute("message") != null && !request.getAttribute("message").equals("")){
					out.println("<span><b>" + request.getAttribute("message") +"</b></span>");							
				}
			%>
	<form action="User?toModus=edit">	
		<div class="clearfix">
			<h3 class="yellow f14">Benutzer</h3>
		</div>					
		<div class="clearfix">			
			<table border="0" class="userTable">
				<tr class="userRow">
					<td class="leftColumn">Kundennummer</td>
					<td class="rightColumn"><%= sMemberID %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Vorname</td>
					<td class="rightColumn"><%= sFirstname %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Nachname</td>
					<td class="rightColumn"><%= sLastname %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Email</td>
					<td class="rightColumn"><%= sEmail %></td>
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
					<td class="rightColumn"><%= sStreet %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Hausnummer</td>
					<td class="rightColumn"><%= sHnr %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">PLZ</td>
					<td class="rightColumn"><%= sZip %></td>
				</tr>
				<tr class="userRow">
					<td class="leftColumn">Ort</td>
					<td class="rightColumn"><%= sPlace %></td>
				</tr>
			</table>
			<div class="register-buttons" style="margin-top: 16px;">				
				<a href="User?toModus=edit" style="margin-left: 25px;"><img src="images/main/edit.png" width="103" height="42" /></a>
			</div>
		</div>
	</form>		
</div>

	