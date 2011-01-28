<%@ page language="java" import="OrderManagement.Order" %>
<%@ page language="java" import="ArticleManagement.Article" %>
<%@ page language="java" import="DBConnection.DBCommands" %>

<div id="content">
	<div class="clearfix">
		<form>
			<div id="basket-table">
					
				<div id="basket-header">
					<div class="inner">
						<span class="basket-bold">Warenkorb</span><br />
						<a href="#" style="float: right; padding-right: 10px;"> 
							<img src="images/basket/refresh.png" alt="Aktualisieren" /> 
						</a> 
					</div>
				</div>
		
				<div id="basket-top">
				<div class="basket-top-cell" style="width:218px; padding-left: 0px;">Product</div>
				<div class="basket-top-cell">Product-Nr.</div>
				<div class="basket-top-cell">Preis</div>
				<div class="basket-top-cell">Menge</div>
				<div class="basket-top-cell" style="border:none;">Aktion</div>
				</div>
		
		
				<div id="basket-middle">
		<%
				if(session.getAttribute("cart") != null)
				{
					double sum = 0;
					Order cart = (Order) session.getAttribute("cart");
					for (int i = 0; i < cart.getOrderLines().size();i++)
					{
						Article article = DBCommands.SelectArticleByID(cart.getOrderLines().get(i).getArticleID());
						out.println("<div class=\"mid_cell\">");
							out.println("<div class=\"basket-left\"><div class=\"mid_cell_height\">" + article.GetTitle() + "</div></div>");
							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\">" + article.GetArticleID() + "</div></div>");
							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\">" + article.GetPrice() + "</div></div>");
							out.println("<div class=\"basket-right\">");
								out.println("<div class=\"mid_cell_height\">");
									out.println("<input name=\"count\" class=\"\" title=\"\" value=\"" + cart.getOrderLines().get(0).getAmount() +"\" size=\"2\" maxlength=\"2\" />");
								out.println("</div>");
							out.println("</div>");
							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\"><a href=\"#\">entfernen</a></div></div>");
						out.println("</div>");
						sum = sum + (article.GetPrice()*cart.getOrderLines().get(i).getAmount());
					}
					out.println("<div id=\"basket-bottom\">");
						out.println("<div class=\"basket-bottom-cell\" style=\"width:218px; padding-left: 0px;\">Summe:</div>");
						out.println("<div class=\"basket-bottom-cell\">"+ sum +"</div>");
						out.println("<div class=\"basket-bottom-cell\"></div>");
						out.println("<div class=\"basket-bottom-cell\"></div>");
						out.println("<div class=\"basket-bottom-cell\" style=\"border:none;\"></div>");
					out.println("</div>");				
				}				
		%>
				<!--
				<div class="mid_cell">
					<div class="basket-left"><div class="mid_cell_height">Harry Potter</div></div>
					<div class="basket-right"><div class="mid_cell_height">10 0020</div></div>
					<div class="basket-right"><div class="mid_cell_height">25.90</div></div>
					<div class="basket-right" >
						<div class="mid_cell_height">
							<input name="count" class="" title="" value="2" size="2" maxlength="2" />
						</div>
					</div>
					<div class="basket-right"><div class="mid_cell_height"><a href="#">entfernen</a></div></div>
				</div>
		
				<div class="mid_cell">
					<div class="basket-left"><div class="mid_cell_height">Harry Potter</div></div>
					<div class="basket-right"><div class="mid_cell_height">10 0020</div></div>
					<div class="basket-right"><div class="mid_cell_height">12.95</div></div>
					<div class="basket-right">
						<div class="mid_cell_height">
							<input name="count" class="" title="" value="1" size="2" maxlength="2" />
						</div>
					</div>
					<div class="basket-right"><div class="mid_cell_height"><a href="#">entfernen</a></div></div>
				</div>
				
				<div class="mid_cell">
					<div class="basket-left"><div class="mid_cell_height">Harry Potter</div></div>
					<div class="basket-right"><div class="mid_cell_height">10 0020</div></div>
					<div class="basket-right"><div class="mid_cell_height">12.95</div></div>
					<div class="basket-right">
						<div class="mid_cell_height">
							<input name="count" class="" title="" value="1" size="2" maxlength="2" />
						</div>
					</div>
					<div class="basket-right"><div class="mid_cell_height"><a href="#">entfernen</a></div></div>
				</div>
		
				-->
				<!--
				<div id="basket-bottom">
					<div class="basket-bottom-cell" style="width:218px; padding-left: 0px;">Summe:</div>
					<div class="basket-bottom-cell"></div>
					<div class="basket-bottom-cell"></div>
					<div class="basket-bottom-cell"></div>
					<div class="basket-bottom-cell" style="border:none;"></div>
				</div>
		
		
				-->
				</div>
		
		
				<div id="basket-footer">
					<div class="inner">
						<span>* MwSt inklusive</span>
						<input class="button" type="submit" value="" />
					</div>
				</div>
			</div>
			
			
		</form>
	</div>
</div>
