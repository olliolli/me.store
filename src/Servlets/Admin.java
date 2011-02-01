package Servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ArticleManagement.Article;
import DBConnection.DBCommands;
import MemberManagement.Member;
import MemberManagement.Role;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null){
			if (session.getAttribute("member") != null) 
			{
				Member member = (Member) session.getAttribute("member");
				if (member.GetMemberRole() == Role.Admin){
					
					Collection<String[]> articles =  DBCommands.GetOrderedArticle();
	
					//Set article List
					request.setAttribute("articles", articles);
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
					dispatcher.forward(request, response);
				}
				else{
					request.setAttribute("toModus", "noPermission");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
					dispatcher.forward(request, response);
				}
			}
			else{
				request.setAttribute("toModus", "noPermission");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			request.setAttribute("toModus", "welcome");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
