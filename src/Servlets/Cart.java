package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBCommands;
import MemberManagement.Member;
import OrderManagement.Order;
import OrderManagement.OrderLine;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("toModus", "cart");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int articleID = 0;
			if(request.getParameter("articleID") != null){
				articleID = Integer.parseInt(request.getParameter("articleID"));
			}
			HttpSession session = request.getSession(false);
			System.out.println(request.getParameter("givenStatus"));
			if(Integer.parseInt(request.getParameter("givenStatus"))==1){
				Order cart = (Order) session.getAttribute("cart");
				ArrayList <OrderLine> newOrderLines = new ArrayList<OrderLine>();
				
				for (int i = 0; i < cart.getOrderLines().size();i++){
					//System.out.println(request.getParameter("delete"+cart.getOrderLines().get(i).getArticleID()));
					if(Boolean.parseBoolean(request.getParameter("delete"+cart.getOrderLines().get(i).getArticleID())))
					{
						DBCommands.DeleteOrderLine(cart.getOrderLines().get(i));
					}
					else
					{
						cart.getOrderLines().get(i).setAmount(Integer.parseInt(request.getParameter("count"+cart.getOrderLines().get(i).getArticleID())));
						newOrderLines.add(cart.getOrderLines().get(i));
						DBCommands.UpdateOrderLine(cart.getOrderLines().get(i));
					}
					
				}
				cart.setOrderLines(newOrderLines);
				session.setAttribute("cart", cart);
			}
			else if(Integer.parseInt(request.getParameter("givenStatus"))==2){
				Order cart = (Order) session.getAttribute("cart");
				DBCommands.AcceptOrder(cart);
				session.setAttribute("cart", null);
			}
			else if(Integer.parseInt(request.getParameter("givenStatus"))==3){
				double price = 0.0;
				if(request.getParameter("newPrice") != null)
					price = Double.parseDouble(request.getParameter("newPrice"));
				else
					price = DBCommands.GetArticleByID(articleID).GetPrice();
				
				if(session.getAttribute("cart")== null)
				{
					Order cart = new Order();
					Member member = (Member) session.getAttribute("member");
					cart.setMember(member);
					DBCommands.NewOrder(cart);
					cart = DBCommands.SelectOpenOrderByMemberID(member.GetMemberID());
					ArrayList<OrderLine> cartPlaces = cart.getOrderLines();
					OrderLine orderLine = new OrderLine();
					orderLine.setArticleID(articleID);
					orderLine.setOrderID(cart.getOrderID());
					orderLine.setAmount(1);
					orderLine.setPrice(price);				
					cartPlaces.add(orderLine);
					DBCommands.NewOrderLine(orderLine);
					cart.setOrderLines(cartPlaces);			
					session.setAttribute("cart",cart);
				}
				else {
					Order cart = (Order) session.getAttribute("cart");
					ArrayList<OrderLine> cartPlaces = cart.getOrderLines();
					boolean exist = false;
					for (int i = 0;i < cartPlaces.size();i++)
					{
						if(cartPlaces.get(i).getArticleID()==articleID)
							exist = true;
					}
					if(exist)
					{
						for (int i = 0;i < cartPlaces.size();i++)
						{
							if(cartPlaces.get(i).getArticleID()==articleID)
							{
								cartPlaces.get(i).setAmount(cartPlaces.get(i).getAmount()+1);
								DBCommands.UpdateOrderLine(cartPlaces.get(i));
							}
						}
						cart.setOrderLines(cartPlaces);
						session.setAttribute("cart", cart);
					}
					else
					{
						OrderLine orderLine = new OrderLine();
						orderLine.setArticleID(articleID);
						orderLine.setOrderID(cart.getOrderID());
						orderLine.setAmount(1);
						orderLine.setPrice(price);
						cartPlaces.add(orderLine);
						DBCommands.NewOrderLine(orderLine);
						cart.setOrderLines(cartPlaces);
						session.setAttribute("cart", cart);
					}
					
				}
			}
			request.setAttribute("toModus", "cart");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		
	}

}
