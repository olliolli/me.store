package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int articleID = Integer.parseInt(request.getParameter("articleID"));
		
		System.out.println(articleID);
		HttpSession session = request.getSession(false);
		if(session.getAttribute("cart")== null)
		{
			Order cart = new Order();
			session.setAttribute("cart",cart);
		}
		else {
			Order cart = (Order) session.getAttribute("cart");
			ArrayList<OrderLine> cartPlaces = cart.getOrderLines();
			OrderLine orderLine = new OrderLine();
			orderLine.setArticleID(articleID);
			orderLine.setOrderID(cart.getOrderID());
			orderLine.setAmount(1);
			cartPlaces.add(orderLine);
			cart.setOrderLines(cartPlaces);
			session.setAttribute("cart", cart);
		}
		
		request.setAttribute("toModus", "cart");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

}
