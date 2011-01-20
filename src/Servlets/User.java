package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String rsUserid = request.getParameter("userId");
		String requestDestination ="";
		
		if (rsUserid != null){
			Member m = DBCommands.SelectMemberByID(Integer.parseInt(rsUserid));
			request.setAttribute("userId", m.GetMemberID());
			request.setAttribute("fname", m.GetFirstName());
			request.setAttribute("lname", m.GetLastName());
			request.setAttribute("email", m.GetEMail());
			request.setAttribute("zip", m.GetPostCode());
			request.setAttribute("street", m.GetStreet());
			request.setAttribute("hnr", m.GetStreetNumber());
			request.setAttribute("place", m.GetCity());
			requestDestination = "/userDataView.jsp";
		}
		else
		{
			requestDestination = "/Home";
		}
		
//		
//		request.setAttribute("object", m);
//		request.setAttribute("userId", m.GetMemberID());
//		request.setAttribute("userId", rsUserid);
//		request.setAttribute("fname", "Roy");
//		request.setAttribute("lname", "");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(requestDestination);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
