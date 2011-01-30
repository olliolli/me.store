<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="ArticleManagement.Article" %> 
<%@ page language="java" import="java.math.*" %>
<%@ page language="java" import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	
		out.println("<div class=\"clearfi	x\">");
			out.println("<a href=\"Home\">");
				out.println("zurück"); 
			out.println("</a>");	
		out.println("</div>");
	
	
		out.println("<div class=\"clearfix\">");
			out.println("<h3 class=\"yellow f14\">");
				out.println("Artikelübersicht"); 
			out.println("</h3>");	
		out.println("</div>");
		
		
	
		//lies die Liste der Artikel aus dem Request
	  	ArrayList arrayList = (ArrayList)request.getAttribute("articles");
	  	//loope über die Liste von Artikeln und gibt die Eigenschaften aus
	  	
	  	if (arrayList != null && arrayList.size() != 0) {
	  		out.println("<div class=\"clearfix\">");
	  		
				out.println("<table align=\"center\">");
		  		
					out.println("<tr class=\"headerRow\"><td>Nr.</td>");
					out.println("<td>Titel</td>");
					out.println("<td>Menge</td>");
					out.println("<td>Umsatz</td></tr>");
				
			  		//Format to show currency with 2 decimal points
			  		DecimalFormat df = new DecimalFormat("0.00");
				  	for (Iterator iter = arrayList.iterator(); iter.hasNext();) {
				  		String[] element = (String[]) iter.next();
				  		
				  		out.println("<tr class=\"tableRow\">");
				  			out.println("<td>");
				  				out.println(element[0]);
				  			out.println("</td>");
				  		
				  			out.println("<td>");
				  				out.println(element[1]);
				  			out.println("</td>");
				  		
				  			out.println("<td>");
				  				out.println(element[2]);
				  			out.println("</td>");
				  		
				  			out.println("<td>");
				  				out.println(element[3]);
				  			out.println("</td>");
				  		
				  		out.println("</tr>");
				  		
				  	}
				  	
			  	out.println("</table>");	
			out.println("</div>");
		
	  	}
	  	else
	  	{
	  		out.println("<div class=\"clearfix\">");
	  			out.println("<p class=\"yellow\"><strong>Es gibt keine Informationen zu verkaufen Artikeln </strong></p>");
	  		out.println("</div>");
	  	}
	
			
			
			
			
	
	%>
</body>
</html>