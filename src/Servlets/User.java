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
//		HttpSession session = request.getSession(false);
//		int rsUserid = (Integer) session.getAttribute("memberID");
		
		String requestDestination ="";
		int rsUserid = 4;
		
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
//			System.out.println(m.GetFirstName());
		}
		
//(String)request.getParameter("toModus") == null ||
		if (request.getParameter("toModus") == null || request.getParameter("toModus").equalsIgnoreCase("view")){
			requestDestination = "/userDataView.jsp";
			System.out.println(1);
		} else if (request.getParameter("toModus").equalsIgnoreCase("edit")){
			System.out.println(2);
			requestDestination = "/userDataEdit.jsp";
		} else if (request.getParameter("toModus").equalsIgnoreCase("commit")){
//			Member member = new Member();
//			member.SetMemberID();
//			member.SetEMail();
//			DBCommands.UpdateMember(member);
			System.out.println(2);
			requestDestination = "/userDataView.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(requestDestination);
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
