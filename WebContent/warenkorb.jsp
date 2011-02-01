<%@ page language="java" import="OrderManagement.Order" %>
<%@ page language="java" import="ArticleManagement.Article" %>
<%@ page language="java" import="DBConnection.DBCommands" %>
<script type="text/javascript">
	function changeStatus(status) {
		document.getElementById("givenStatus").value = status;
		document.frmCart.submit();		
	}
</script>
<div id="content">
	<div class="clearfix">
	<form name="frmCart" action="Cart" method="post">
	<input type="hidden" name="givenStatus" id="givenStatus" value="2" />
			<div id="basket-table">
				<div id="basket-header">
					<div class="inner">
						<span class="basket-bold">Warenkorb</span><br />
						<a href="javascript:changeStatus(1);" style="float: right; padding-right: 10px;"> 
							<img src="images/basket/refresh.png" alt="Aktualisieren" /> 
						</a> 
					</div>
				</div>
		
				<div id="basket-top">
				<div class="basket-top-cell" style="width:218px; padding-left: 0px;">Product</div>
				<div class="basket-top-cell">Product-Nr.</div>
				<div class="basket-top-cell">Preis</div>
				<div class="basket-top-cell">Menge</div>
				<div class="basket-top-cell" style="border:none;">Löschen</div>
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
							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\">" + cart.getOrderLines().get(i).getPrice() + "</div></div>");
							out.println("<div class=\"basket-right\">");
								out.println("<div class=\"mid_cell_height\">");
									out.println("<input name=\"count"+article.GetArticleID()+"\" class=\"\" title=\"\" value=\"" + cart.getOrderLines().get(i).getAmount() +"\" size=\"2\" maxlength=\"2\" />");
								out.println("</div>");
							out.println("</div>");
//							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\"><a href=\"javascript:document.frmCart.submit();\">entfernen</a></div></div>");
							out.println("<div class=\"basket-right\"><div class=\"mid_cell_height\"><input name=\"delete"+article.GetArticleID()+"\" id=\"delete"+article.GetArticleID()+"\" type=\"checkbox\" value=\"true\"></div></div>");
						out.println("</div>");
						
						
						sum = sum + (cart.getOrderLines().get(i).getPrice()*cart.getOrderLines().get(i).getAmount());
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
