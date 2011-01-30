package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.MediumType;
import DBConnection.DBCommands;
import DBConnection.DBControl;

/**
 * Servlet implementation class List
 */
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get search Parameter		
		String rsMedium = request.getParameter("med");
		String rsCategory = request.getParameter("cat");
		String rsOption = request.getParameter("opt");
		String rsSearchQuery = request.getParameter("searchQuery");
		

		Collection<Article> articles =  DBCommands.GetArticlesBySearchParameters(rsMedium, rsCategory, rsOption, rsSearchQuery);

		//Set article List
		request.setAttribute("articles", articles);
		
		//Set search Parameter to show it in the header line of the search result
		request.setAttribute("med", rsMedium);
		request.setAttribute("cat", rsCategory);
		request.setAttribute("opt", rsOption);
		
		//Set cookie to save display status
		//Needed to get redirected from login page to this view directly.
		String pageString = "/List?";
		if (rsMedium != null)
			pageString += "med=" + rsMedium +"&";
		if (rsCategory != null)
			pageString += "cat=" + rsCategory +"&";
		if (rsOption != null)
			pageString += "opt=" + rsOption +"&";
		if (rsSearchQuery != null)
			pageString += "searchQuery=" + rsSearchQuery;
		
		pageString = pageString.substring(0,pageString.length()-1);
		
		
		Cookie lastPage = new Cookie("lastPage", pageString);
		response.addCookie(lastPage);
		
		
		//Set page Parameter. 
		request.setAttribute("toModus", "list");
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
