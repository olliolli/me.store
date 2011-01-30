<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="ArticleManagement.Article" %> 
<%@ page language="java" import="java.math.*" %>
<%@ page language="java" import="java.text.DecimalFormat" %>

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
	  	
	  	if (arrayList != null && arrayList.size() != 0) {
	  		//Format to show currency with 2 decimal points
	  		DecimalFormat df = new DecimalFormat("0.00");
		  	for (Iterator iter = arrayList.iterator(); iter.hasNext();) {
		  		Article element = (Article) iter.next();
				out.println("<form name=\"frmArticle" + element.GetArticleID() + "\" action=\"Cart\" method=\"post\" class=\"articleContainer\">");
			  		out.println("<div class=\"clearfix\">");
				  		out.println("<p class=\"yellow\"><strong>" + element.GetTitle() + "</strong></p>");
				  		out.println("<div class=\"left\"><img src=" + element.GetPicturePath() + " alt=\"\" height=\"120\"  /></div>");
						out.println("<div class=\"right\">");
						
							if (element.GetDescription().length() > 350){
								//find next space (so that no word is splitted)
								int spacePos = element.GetDescription().indexOf(" ",350);
								if (spacePos != -1)
									out.println("<p>" + element.GetDescription().substring(0,spacePos));
								out.println("<a href=\"Details?id=" + element.GetArticleID() +"\" style=\"color: #4D61C6;\">&lt;more&gt;</a> ");
								out.println("</p>");
							}
							else {
								out.println("<p>" + element.GetDescription() +"</p>");
							}
							
							out.println("<div class=\"itemDetails\">");
							
								if (element.GetDiscount() != 0.0){
									out.println("<div class=\"discount\">");
										out.println("<span>reduziert von </span>");
										out.println("<span>" + df.format(element.GetPrice()) + "</span>");
										out.println("<span>&euro;</span>");
										out.println("<span> auf </span>");
									out.println("</div>");								
									out.println("<div class=\"price\" style=\"color: #FF0A0E;\">");
										double newPrice = Math.rint( element.GetPrice() * (1-(element.GetDiscount() / 100.0)) * 100.) / 100.;
										out.println("<b><span>"+ df.format(newPrice) +"</span></b>");
										out.println("<span>&euro;</span>");
									out.println("</div>");
								}
								else {
									out.println("<div class=\"price\">");
										out.println("<b><span>"+ df.format(element.GetPrice()) +"</span></b>");
										out.println("<span>&euro;</span>");
									out.println("</div>");
								}
								
								out.println("<div class=\"details\"><a href=\"Details?id=" + element.GetArticleID() +"\"></a> </div>");
								out.println("<div class=\"buy\"><a href=\"javascript: document.frmArticle" + element.GetArticleID() + ".submit();\"></a> </div>");
								out.println("<input type=\"hidden\" name=\"articleID\" value=\""+ element.GetArticleID()  +"\" />");
							out.println("</div>");
						out.println("</div>");
					out.println("</div>");
				out.println("</form>");
		  		
		  	}
	  	}
	  	else
	  	{
	  		out.println("<div class=\"clearfix\">");
	  			out.println("<p class=\"yellow\"><strong>Ihre Suche ergab leider keine Produkttreffer. </strong></p>");
	  		out.println("</div>");
	  	}
	  	
	  %>
	
</div>