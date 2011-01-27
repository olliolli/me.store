package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberManagement.Member;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if(!session.isNew()){
			if (session.getAttribute("member") != null) 
			{
				Member member = (Member) session.getAttribute("member");
				System.out.println(member);
				session.setMaxInactiveInterval(3600);
				if(member.GetMemberID() >= 1){
					System.out.println("Eingeloggt");
				}
				else{
					System.out.println("Nicht eingeloggt");
				}
			}
			else{
				System.out.println("Nicht eingeloggt");
			}
		}	
		else{
			session.setMaxInactiveInterval(10);
			System.out.println("Neu");
		}
		
		
		//SimulateDB simulateDB = new SimulateDB();
		
		
		//Collection collection = simulateDB.getAllBooks(session);
		
		
		//request.setAttribute("books", collection);
		
		request.setAttribute("toModus", "welcome");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
