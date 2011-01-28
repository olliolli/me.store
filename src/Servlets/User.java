package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBCommands;
import MemberManagement.Member;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		int rsUserid = member.GetMemberID();
		
		String requestDestination ="";
//		int rsUserid = 1;
		
		if (rsUserid >= 1){	
			Member m = DBCommands.SelectMemberByID(rsUserid);
			request.setAttribute("memberID", m.GetMemberID());
			request.setAttribute("fname", m.GetFirstName());
			request.setAttribute("lname", m.GetLastName());
			request.setAttribute("email", m.GetEMail());
			request.setAttribute("zip", m.GetPostCode());
			request.setAttribute("street", m.GetStreet());
			request.setAttribute("hnr", m.GetStreetNumber());
			request.setAttribute("place", m.GetCity());
		}
		
		if (request.getParameter("toModus")== null || request.getParameter("toModus").equalsIgnoreCase("view")){
			request.setAttribute("toModus", "userView");
			System.out.println(1);
		} else if (request.getParameter("toModus").equalsIgnoreCase("edit")){
			System.out.println(2);
			request.setAttribute("toModus", "userEdit");
		} else if (request.getParameter("toModus").equalsIgnoreCase("commit")){
			member.SetMemberID(Integer.parseInt(request.getParameter("memberID")));
			member.SetCity(request.getParameter("place"));
			member.SetEMail(request.getParameter("email"));
			member.SetFirstName(request.getParameter("firstname"));
			member.SetLastName(request.getParameter("lastname"));
			member.SetPostCode(request.getParameter("zip"));
			member.SetStreet(request.getParameter("street"));
			member.SetStreetNumber(request.getParameter("hnr"));
			try{
				DBCommands.UpdateMember(member);
			}
			catch (Exception e){
			}
			
			System.out.println(3);
			if (rsUserid >= 1){	
				Member m = DBCommands.SelectMemberByID(rsUserid);
				request.setAttribute("memberID", m.GetMemberID());
				request.setAttribute("fname", m.GetFirstName());
				request.setAttribute("lname", m.GetLastName());
				request.setAttribute("email", m.GetEMail());
				request.setAttribute("zip", m.GetPostCode());
				request.setAttribute("street", m.GetStreet());
				request.setAttribute("hnr", m.GetStreetNumber());
				request.setAttribute("place", m.GetCity());
			}
//			System.out.println(member.GetMemberID());
			request.setAttribute("toModus", "userView");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
