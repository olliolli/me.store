<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="ArticleManagement.Article" %> 


<div id="content">
	<div class="clearfix">
		<h3 class="yellow f14">
			Herzlich willkommen
		</h3>	
	</div>
	<div class="clearfix">
		<p>
			Wir, das Team von <font color="#999966"><b>me.store</b></font>, begrüßen Sie ganz herzlich auf unserer Seite.
		</p>
		<p>
			Benutzen Sie einfach unsere Suche um Ihren gewünschten Artikel zu finden 
			
			oder benutzen Sie die komfortable Schnellsuche im oberen Bereich der Seite.
		</p>
		<p>
			Ihr Service Team von
		</p>
		</p>
			<font color="#999966"><b>me.store</b></font>
		</p>	
	</div>
	
	<% 
		if (request.getAttribute("visitedArticles") != null){
			
			//lies die Liste der Artikel aus dem Request
		  	ArrayList arrayList = (ArrayList)request.getAttribute("visitedArticles");
		  	//loope über die Liste von Artikeln und gibt die Eigenschaften aus
		  	
		  	if (arrayList != null && arrayList.size() != 0) {
			  	out.println("<div class=\"clearfix\">");
					out.println("<h3 class=\"yellow f14\">");
						out.println("Sie haben sich zuletzt folgende Artikel angesehen"); 
					out.println("</h3>");	
				out.println("</div>");		  		
		  		
				out.println("<div class=\"clearfix\">");
				  	for (Iterator iter = arrayList.iterator(); iter.hasNext();) {
				  		Article element = (Article) iter.next();						
							out.println("<div class=\"articleBoxWelcome\">");
					  			out.println("<div><img src=" + element.GetPicturePath() + " alt=\"\" height=\"120\"  /></div>");
						  		out.println("<div class=\"detailsWelcome\"><a href=\"Details?id=" + element.GetArticleID() +"\"></a> </div>");
						  	out.println("</div>");
				  		
				  	}
			  	out.println("</div>");
		  	}
			
		}
	
	%>
	
	
</div>

