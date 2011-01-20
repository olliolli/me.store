
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
	
	<script type="text/javascript" src="js/jquery.min.1.4.2.js"></script>
	<script type="text/javascript" src="js/interface.js"></script>
	
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
				  <a class="dock-item" href="List?opt=best"><img src="images/dockNavigation/bestseller.png" alt="bestseller" /><span>Bestseller</span></a> 			  
				  <a class="dock-item" href="List?opt=new"><img src="images/dockNavigation/history.png" alt="neu" /><span>Neuerscheinungen</span></a> 
				  <a class="dock-item" href="List?opt=discount"><img src="images/dockNavigation/reduziert.png" alt="reduziert" /><span>Reduzierte Ware</span></a> 
				  <a class="dock-item" href="List?med=Musik"><img src="images/dockNavigation/music.png" alt="musik" /><span>Musik</span></a> 
				  <a class="dock-item" href="List?med=Film"><img src="images/dockNavigation/video.png" alt="video" /><span>Filme</span></a> 
				  <a class="dock-item" href="List?med=Buch"><img src="images/dockNavigation/buch.png" alt="buch" /><span>Bücher</span></a> 
				</div>
			</div>
	        <div id="topnav">			
				<div id="usersection">
					<a href="Login"><span>Login</span></a>
					<a href="#"><span>mein Konto</span></a>
				</div>
				<div id="basket_outer">
					<div id="basket_inner">
						<a href="Cart">
							<span>Warenkorb</span>
							<span> | </span>
							<span>0 Artikel</span>
						</a>
					</div>
				</div>	
	        </div>
	    </div>
	</div>
	<div id="mainnav-wrap" class="wrap">
	    <div id="mainnav" class="pagesize clearfix">
	    	<div class="searchnav">			
				<form name="searchform" method="post" action="" id="searchform">
					<span class="topic">Suche</span>
					<span>Medium</span>
					<select name="searchMedium">
						<option value="NN"></option>
						<option value="Bücher">Bücher</option>
						<option value="Musik">Musik</option>
						<option value="Filme">Filme</option>
						<option value="E-Books">E-Books</option>
					</select>
				
					<span>Kategorie</span>
					<select name="searchCategory">
						<option value="NN"></option>
						<option value="Horror">Horror</option>
						<option value="Action">Action</option>
						<option value="Fantasie">Fantasie</option>
						<option value="Bildung">Bildung</option>
					</select>
					
					<input class="searchquery" name="searchQuery" type="text" maxlength="30">
					
					<input class="searchGo" type="submit" value="">				
				</form>
	        </div>
	    </div>
	</div>
	<div id="container-wrap" class="wrap">
	    <div id="container" class="pagesize clearfix">
	    	<div id="leftcol">
	        	<div class="inner">            	
					<jsp:include page="verticalNavigation.jsp" flush="true" />
	            </div>
	        </div>
	        <div id="maincol">
	        	<div id="banner" class="clearfix">
	            	<div id="banner-content">
	                	<h1>Dein Medien - PARTNER</h1>
	                    <p class="f14">Me.store</p>
	                </div>
	            </div>
	            <div id="content-wrap">
	            
	            
	            	 <% String toModus = (String)request.getAttribute("toModus");
	            			            
	            		if (toModus == "cart") {
	            	%>
	            		<jsp:include page="warenkorb.jsp" flush="true" />
	            		
	            	<%  }
	            		if (toModus == "home") {%>
	            		<jsp:include page="content.jsp" flush="true" />
	            		
	            	<%  }
	            		if (toModus == "list") {%>
	            		<jsp:include page="content.jsp" flush="true" />
	            		
	            	<% } %>
	            	
	            </div>
	            <div id="footer">
	            	&copy; Copyright 2011 Me.store
	            </div>
	        </div>
	        <div id="rightcol">
	        	<div class="inner">
	            	<img src="images/main/testwerbung.png" />
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
				)
			}
		);
		
	</script>

</body>
</html>
