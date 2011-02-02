package Servlets;

import java.io.IOException;

import javax.naming.ServiceUnavailableException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		request.setAttribute("error", "");
		
		
		if(request.getParameter("toModus") != null && request.getParameter("toModus").equals("cancel")){

			
			String redirectURL = "/me.store";
			
			//Get last visited Page
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null){
				for(int i=0; i < cookies.length; i++) {		
					Cookie c = cookies[i];
					if (c.getName().equals("lastPage")) {
						String cookieValue =Details.decodeString(c.getValue());	
						if (!cookieValue.equals("")){
							redirectURL += cookieValue;
						}
						break;
					}
					
				}
			}			
			
			if (redirectURL.equals("/me.store"))
				redirectURL += "/Home";
			
			response.sendRedirect(redirectURL);
		}
		else{		
		
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
				
				String redirectURL = "/me.store";
				
				//Get last visited Page
				Cookie[] cookies = request.getCookies();
				
				if (cookies != null){
					for(int i=0; i < cookies.length; i++) {		
						Cookie c = cookies[i];
						if (c.getName().equals("lastPage")) {
							String cookieValue =Details.decodeString(c.getValue());	
							if (!cookieValue.equals("")){
								redirectURL += cookieValue;
							}
							break;
						}
						
					}
				}			
				
				if (redirectURL.equals("/me.store"))
					redirectURL += "/Home";
				
				response.sendRedirect(redirectURL);
			}
			else{
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
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
			Member member = MemberManagement.MemberLogin.returnMember(eMail, pwdHash);
			if(member.GetMemberID() >= 1){
				HttpSession session = request.getSession(true);
				session.setAttribute("member", member);
				Order order = DBCommands.SelectOpenOrderByMemberID(member.GetMemberID());
				if(order.getOrderID()>=1)
					session.setAttribute("cart", order );
				else
					session.setAttribute("cart", null);
				
				if(session.getAttribute("cart")==null)
				{
					System.out.println("Kein Cart Object");
					Order cart = new Order();
					cart.setMember(member);
					DBCommands.NewOrder(cart);
					cart = DBCommands.SelectOpenOrderByMemberID(member.GetMemberID());
					session.setAttribute("cart", cart);
				}
				else
					System.out.println("CartObject vorhanden");

				String redirectURL = "/me.store";
				
				//Get recently visited Articles
				Cookie[] cookies = request.getCookies();
				
				if (cookies != null){
					for(int i=0; i < cookies.length; i++) {		
						Cookie c = cookies[i];
						if (c.getName().equals("lastPage")) {
							String cookieValue =Details.decodeString(c.getValue());	
							if (!cookieValue.equals("")){
								redirectURL += cookieValue;
							}
							break;
						}
						
					}
				}			
				
				if (redirectURL.equals("/me.store"))
					redirectURL += "/Home";
				
				response.sendRedirect(redirectURL);
				
			}
			else{
				HttpSession session = request.getSession(true);
				session.setAttribute("member", member);		
				session.setAttribute("cart", null);
				request.setAttribute("error", "Ihre Eingabe war leider nicht richtig");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}


