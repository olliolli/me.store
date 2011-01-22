<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="ArticleManagement.Article" %> 
<%@ page language="java" import="java.math.*" %>

<div id="content">
	
	<%
		if (request.getAttribute("med") != null){
			out.println("<div class=\"clearfix\">");
				out.println("<h3 class=\"yellow f14\">");
					out.println(request.getAttribute("med")); 
				out.println("</h3>");	
			out.println("</div>");
		}
		
		if (request.getAttribute("cat") != null){
			out.println("<div class=\"clearfix\">");
				out.println("<h3 class=\"yellow f14\">");
					out.println(request.getAttribute("cat")); 
				out.println("</h3>");	
			out.println("</div>"); 
		}
		
		if (request.getAttribute("opt") != null){
			out.println("<div class=\"clearfix\">");
				out.println("<h3 class=\"yellow f14\">");
					out.println(request.getAttribute("opt")); 
				out.println("</h3>");	
			out.println("</div>"); 
		}
	
	  
	  	//lies die Liste der Artikel aus dem Request
	  	ArrayList arrayList = (ArrayList)request.getAttribute("articles");
	  	//loope über die Liste von Artikeln und gibt die Eigenschaften aus
	  	if (arrayList != null) {
		  	for (Iterator iter = arrayList.iterator(); iter.hasNext();) {
		  		Article element = (Article) iter.next();
	
		  		out.println("<div class=\"clearfix\">");
			  		out.println("<p class=\"yellow\"><strong>" + element.GetTitle() + "</strong></p>");
			  		out.println("<div class=\"left\"><img src=" + element.GetPicturePath() + " alt=\"\" height=\"120\"  /></div>");
					out.println("<div class=\"right\">");
						out.println("<p>" + element.GetDescription() +"</p>");
						out.println("<div class=\"itemDetails\">");
							out.println("<div class=\"discount\">");
								out.println("<span>reduziert von </span>");
								out.println("<span>" + element.GetPrice() + "</span>");
								out.println("<span>&euro;</span>");
								out.println("<span> auf </span>");
							out.println("</div>");
							out.println("<div class=\"price\">");
								out.println("<b><span>"+ element.GetPrice() * (1-(element.GetDiscount() / 100.0))  +"</span></b>");
								out.println("<span>&euro;</span>");
							out.println("</div>");
							out.println("<div class=\"buy\"><a href=\"#\"></a> </div>");
						out.println("</div>");
					out.println("</div>");
				out.println("</div>");
		  		
		  	}
	  	}
	  %>
	
</div>