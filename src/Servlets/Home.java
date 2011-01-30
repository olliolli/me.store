package Servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ArticleManagement.Article;
import DBConnection.DBCommands;
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
				session.setMaxInactiveInterval(2*60*60);//2hours
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
			session.setMaxInactiveInterval(2*60*60); //2hours
			System.out.println("Neue Session");
		}
		
		
		
		//Get recently visited Articles
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null){
			for(int i=0; i < cookies.length; i++) {		
				Cookie c = cookies[i];
				if (c.getName().equals("watchedArticles")) {
					String cookieValue =Details.decodeString(c.getValue());	
					if (!cookieValue.equals("")){
						
						String[] articleIDsString = cookieValue.split("\\,");
						int[] articleIDsInt = new int[articleIDsString.length];
						for(int y = 0; y < articleIDsString.length; y++){
							try{
								articleIDsInt[y] = Integer.parseInt(articleIDsString[y]);
							}
							catch(NumberFormatException e){}
							
						}
						
						Collection<Article> articles =  DBCommands.GetArticlesByIDs(articleIDsInt);
						
						//Set article List
						request.setAttribute("visitedArticles", articles);
						
					}
					
				}		
			}
		}
		
		Cookie lastPage = new Cookie("lastPage", "/Home");
		response.addCookie(lastPage);
		
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
