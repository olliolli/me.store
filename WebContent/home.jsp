<%@ page language="java" import="MemberManagement.Member" %> 
<html>
<head>
	<title>home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	
	<link href="css/reset.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/typography.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/main.css" rel="stylesheet" type="text/css" />
	<link href="css/dockNavigation.css" rel="stylesheet" type="text/css" />
	<link href="css/content.css" rel="stylesheet" type="text/css" />
	<link href="css/warenkorb.css" rel="stylesheet" type="text/css" />
	<link href="css/userView.css" rel="stylesheet" type="text/css" />
	<style type="text/css" media="screen, projection">
		@import url(css/jq_fade.css);
	</style>	
	
	
	<script type="text/javascript" src="js/jquery.min.1.4.2.js"></script>
	<script type="text/javascript" src="js/interface.js"></script>
	<script type="text/javascript" src="js/jquery.innerfade.js"></script>
	
	<!--[if lte IE 6]>
	<style type="text/css">
	.clearfix {height: 1%;}
	img {border: none;}
	#resol {position:absolute;} body {overflow-x: hidden;} 
	</style>
	<![endif]-->
	<!--[if gte IE 7.0]>
	<style type="text/css">
	.clearfix {display: inline-block;}
	</style>
	<![endif]-->



</head>
<body>
	<div id="mainwrap">																																																																																																																																																																																																																																																																																																																				
	<div id="header-wrap" class="wrap">
		<div id="header" class="pagesize">
	        <div id="logo"></div>
			<div class="dock" id="dock">
			  <div class="dock-container">
				  <a class="dock-item" href="Home"><img src="images/dockNavigation/home.png" alt="home" /><span>Home</span></a> 
				  <a class="dock-item" href="List?opt=Bestseller"><img src="images/dockNavigation/bestseller.png" alt="bestseller" /><span>Bestseller</span></a> 			  
				  <a class="dock-item" href="List?opt=Neu"><img src="images/dockNavigation/history.png" alt="neu" /><span>Neuerscheinungen</span></a> 
				  <a class="dock-item" href="List?opt=Reduziert"><img src="images/dockNavigation/reduziert.png" alt="reduziert" /><span>Reduzierte Ware</span></a> 
				  <a class="dock-item" href="List?med=Musik"><img src="images/dockNavigation/music.png" alt="musik" /><span>Musik</span></a> 
				  <a class="dock-item" href="List?med=Film"><img src="images/dockNavigation/video.png" alt="video" /><span>Film</span></a> 
				  <a class="dock-item" href="List?med=Buch"><img src="images/dockNavigation/buch.png" alt="buch" /><span>Buch</span></a> 
				</div>
			</div>
	        <div id="topnav">			
				
			<%
			out.println("<div id=\"usersection\">");
				if (session.getAttribute("member") != null) {
					Member member = (Member)session.getAttribute("member");
					if (member.GetMemberID() != 0){
						out.println("<a href=\"Login?logedIn=true\"><span>Logout</span></a>");
						out.println("<a href=\"User\"><span>mein Konto</span></a>");	
					}
					else {
						out.println("<a href=\"Login\"><span>Login</span></a>");						
					}
				}	
				else {
					out.println("<a href=\"Login\"><span>Login</span></a>");						
				}
			out.println("</div>");
			out.println("<div id=\"basket_outer\">");
				out.println("<div id=\"basket_inner\">");
					out.println("<a href=\"Cart\">");
						out.println("<span>Warenkorb</span>");
						out.println("<span> | </span>");
						out.println("<span>0 Artikel</span>");
					out.println("</a>");
				out.println("</div>");
			out.println("</div>");					
			%>					
	        </div>
	    </div>
	</div>
	<div id="mainnav-wrap" class="wrap">
	    <div id="mainnav" class="pagesize clearfix">
	    	<div class="searchnav">			
				<form name="searchform" method="get" action="List" id="searchform">
					<span class="topic">Suche</span>
					<span>Medium</span>
					<select name="med">
						<option value=""></option>
						<option value="Buch">Buch</option>
						<option value="eBook">eBook</option>
						<option value="DVD">DVD</option>
						<option value="BluRay">BluRay</option>
						<option value="Musik">Musik</option>
						<option value="GamePlayStation1">GamePlayStation1</option>
						<option value="GamePlayStation2">GamePlayStation2</option>
						<option value="Film">Film</option>
					</select>
				
					<span>Kategorie</span>
					<select name="cat">
						<option value=""></option>
						<option value="Horror">Horror</option>
						<option value="Fantasy">Fantasy</option>
						<option value="ScienceFiction">ScienceFiction</option>
						<option value="Komödie">Komödie</option>
						<option value="Action">Action</option>
						<option value="Western">Western</option>
						<option value="Pop">Pop</option>					
					</select>
					
					<input class="search" name="searchQuery" type="text" maxlength="30">
					
					<input class="searchGo" type="submit" value="">				
				</form>
	        </div>
	    </div>
	</div>
	<div id="container-wrap" class="wrap">
	    <div id="container" class="pagesize clearfix">
	    	<div id="leftcol">
	        	<div class="inner">            	
					
	            </div>
	        </div>
	        <div id="maincol">
	        	<div id="banner" class="clearfix">
	            	<div id="banner-content">
	            		<%
	            		
							if (session.getAttribute("member") != null) {
								Member member = (Member)session.getAttribute("member");
								if (member.GetMemberID() != 0){
									out.println("<p class=\"f14\">");
										out.println("Willkommen ");
										out.println(member.GetLastName() + ", " + member.GetFirstName());
									out.println("</p>");
								}
							}	
	            		
						%>	                    
	                </div>
	            </div>
	            <div id="content-wrap">
	            
	            
	            	<% String toModus = (String)request.getAttribute("toModus");
	            			            
	            		if (toModus == "cart") {
	            	%>
	            		<jsp:include page="warenkorb.jsp" flush="true" />
	            		
	            	<%  }
	            		if (toModus == "welcome") {%>
	            		<jsp:include page="welcome.jsp" flush="true" />
	            		
	            	<%  }
	            		if (toModus == "list") {%>
	            		<jsp:include page="content.jsp" flush="true" />
	            		
	            	<%  }
	            		if (toModus == "error") {%>
	            		<jsp:include page="error.jsp" flush="true" />
	            	<%  }
	            		if (toModus == "noPermission") {%>
	            		<jsp:include page="noPermission.jsp" flush="true" />
	            	<%  }
	            		if (toModus == "userView") {%>
	            		<jsp:include page="userDataView.jsp" flush="true" />
	            	<%  }
	            		if (toModus == "userEdit") {%>
	            		<jsp:include page="userDataEdit.jsp" flush="true" />
	            		
	            	<% }
	            		if (toModus == "details") {%>
	            		<jsp:include page="details.jsp" flush="true" />
	            		
	            	<% } %>
	            	
	            </div>
	            <div id="footer">
	            	&copy; Copyright 2011 Me.store
	            </div>
	        </div>
	        <div id="rightcol">
	        	<div class="inner">
	          
	          		<ul id="portfolio"> 
	          			<li> 
	          				<a href="Details?id=22"> 
	          					<img src="images/promotion/avatar.png" alt="Avatar" /> 
	          				</a> 
	          			</li>
						<li> 
							<a href="Details?id=20"> 
								<img src="images/promotion/bankJob.png" alt="Bank Job" /> 
							</a> 
						</li> 
						<li> 
							<a href="Details?id=6"> 
								<img src="images/promotion/residentEvil.png" alt="Resident Evil 2" /> 
							</a> 
						</li> 						
					</ul> 
	          
	          
	            </div>
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript">
		
		$(document).ready(
			function()
			{
				$('#dock').Fisheye(
					{
						maxWidth: 50,
						items: 'a',
						itemsText: 'span',
						container: '.dock-container',
						itemWidth: 40,
						proximity: 90,
						halign : 'center'
					}
				);
				$('#portfolio').innerfade(
					{ 
						speed: 'slow', 
						timeout: 4000, 
						type: 'sequence', 
						containerheight: '350px' 
					}
				); 				
			}
		);
		
	</script>

</body>
</html>
