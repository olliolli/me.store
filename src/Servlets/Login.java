package Servlets;

import java.io.IOException;

import javax.naming.ServiceUnavailableException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBCommands;
import MemberManagement.Member;
import MemberManagement.MemberRegistration;
import MemberManagement.PasswordService;
import OrderManagement.Order;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("logedIn")!= null)
		{
			String logedIn = request.getParameter("logedIn");
			boolean isLogedIn = Boolean.parseBoolean(logedIn);
			if (isLogedIn)
			{
				HttpSession session = request.getSession(false);
				if(session.getAttribute("cart") != null)
				{
					Order cart = (Order) session.getAttribute("cart");
					if(!cart.getIsAlreadyOrdered())
					{
						//DBCommands.NewOrder(cart);
						for (int i = 0; i < cart.getOrderLines().size();i++)
						{
							//DBCommands.NewOrderLine(cart.getOrderLines().get(i));
							System.out.println(cart.getOrderLines().get(i));
						}
					}
				}
				session.invalidate();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		
			String eMail = request.getParameter("username").toUpperCase();
			String pwdHash = null;
			try {
				//Das eingegebene Passwort wird in einen Hashwert überführt
				pwdHash = PasswordService.getInstance().Encrypt(request.getParameter("password"));
				// Alle Parameter werden an RegistrateUser übergeben und der User wird gepseichert.
			} catch (ServiceUnavailableException e) {
				e.printStackTrace();
			}
			System.out.println(pwdHash);
			Member member = MemberManagement.MemberLogin.returnMember(eMail, pwdHash);
			if(member.GetMemberID() >= 1){
				HttpSession session = request.getSession(true);
				session.setAttribute("member", member);
				System.out.println(member.GetMemberID());
				Order order = DBCommands.SelectOpenOrderByMemberID(member.GetMemberID());
				session.setAttribute("cart", order );
				order = (Order) session.getAttribute("cart");
				System.out.println(order.getOrderID());
				System.out.println(order.getOrderLines().size());
				for (int i = 0; i < order.getOrderLines().size();i++)
				{
					System.out.println(order.getOrderLines().get(0).getArticleID());
				}
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home");
				dispatcher.forward(request, response);
			}
			else{
				HttpSession session = request.getSession(true);
				session.setAttribute("member", member);		
				session.setAttribute("cart", null);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}


