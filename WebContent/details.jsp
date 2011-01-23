<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="ArticleManagement.Article" %> 
<%@ page language="java" import="java.math.*" %>
<%@ page language="java" import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/details.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
<div id="contentDetails">
	
	<%
		Article element = (Article)request.getAttribute("article");
		//Format to show currency with 2 decimal points
		DecimalFormat df = new DecimalFormat("0.00");
	  
		out.println("<form name=\"frmArticle" + element.GetArticleID() + "\" action=\"Cart\" method=\"post\" class=\"detailsContainer\">");
	  		out.println("<div class=\"clearfix\">");		  		
		  		out.println("<div class=\"leftDetails\"><img src=" + element.GetPicturePath() + " alt=\"\" height=\"300\"  /></div>");
				out.println("<div class=\"rightDetails\">");
				
					out.println("<table id=\"detailsTable\">");
											
						out.println("<tr>");
							out.println("<td class=\"detailsTableLeft\">");
								out.println("<span>");
									out.println("Title"); 
								out.println("</span>");
							out.println("</td>");
							out.println("<td class=\"detailsTableRight\">");
								out.println("<span>");
									out.println(element.GetTitle()); 
								out.println("</span>");
							out.println("</td>");
						out.println("</tr>");
						
						out.println("<tr>");
							out.println("<td class=\"detailsTableLeft\">");
								out.println("<span>");
									out.println("Medium"); 
								out.println("</span>");
							out.println("</td>");
							out.println("<td class=\"detailsTableRight\">");
								out.println("<span>");
									out.println(element.GetMediumType()); 
								out.println("</span>");
							out.println("</td>");
						out.println("</tr>");
						
						out.println("<tr>");
							out.println("<td class=\"detailsTableLeft\">");
								out.println("<span>");
									out.println("Genre"); 
								out.println("</span>");
							out.println("</td>");
							out.println("<td class=\"detailsTableRight\">");
								out.println("<span>");
									out.println(element.GetGenre()); 
								out.println("</span>");
							out.println("</td>");
						out.println("</tr>");
						
						out.println("<tr>");
							out.println("<td class=\"detailsTableLeft\">");
								out.println("<span>");
									out.println("Preis"); 
								out.println("</span>");
							out.println("</td>");
							out.println("<td class=\"detailsTableRight\">");
	
								if (element.GetDiscount() != 0){
									out.println("<div class=\"discount\">");
										out.println("<span>reduziert von </span>");
										out.println("<span>" + df.format(element.GetPrice()) + "</span>");
										out.println("<span>&euro;</span>");
										out.println("<span> auf </span>");
									out.println("</div>");								
									out.println("<div class=\"price\" style=\"color: #FF0A0E;\">");
										double newPrice = Math.rint( element.GetPrice() * (1-(element.GetDiscount() / 100.0)) * 100.) / 100.;
										out.println("<span>"+ df.format(newPrice) +"</span>");
										out.println("<span>&euro;</span>");
									out.println("</div>");
								}
								else {
									out.println("<div class=\"price\">");
										out.println("<b><span>"+ df.format(element.GetPrice()) +"</span></b>");
										out.println("<span>&euro;</span>");
									out.println("</div>");
								}
							
							
							
							out.println("</td>");
						out.println("</tr>");
						
						out.println("<tr>");
							out.println("<td class=\"detailsTableLeft\">");
								out.println("<span>");
									out.println(""); 
								out.println("</span>");
							out.println("</td>");
							out.println("<td class=\"detailsTableRight\">");
								out.println("<div class=\"buy\"><a href=\"javascript: document.frmArticle" + element.GetArticleID() + ".submit();\"></a> </div>");
							out.println("</td>");
						out.println("</tr>");
						
					out.println("</table>");
					
				
				out.println("</div>");
			out.println("</div>");
			
			out.println("<div class=\"clearfix\">");
				out.println("<h3 class=\"yellow f14\">");
					out.println("Beschreibung"); 
				out.println("</h3>");	
			out.println("</div>");
			out.println("<div class=\"clearfix\">");
				out.println("<div class=\"descriptionContainer\">");
					out.println("<p>" + element.GetDescription() +"</p>");
				out.println("</div>");
			out.println("</div>");
		out.println("</form>");  		
	  	
	  
	  %>
	
</div>
</body>
</html>