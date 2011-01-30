package Servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.Rating;
import ArticleManagement.MediumType;
import DBConnection.DBCommands;
import DBConnection.DBControl;
import MemberManagement.Member;

/**
 * Servlet implementation class Details
 */
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public static String encodeString(String s) {
        String encodedString = s;

        try{
            encodedString = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {}

        return encodedString;
    }
    public static String decodeString(String s) {
        String decodedString = s;

        try{
            decodedString = URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {}

        return decodedString;
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleID = "";
		if (request.getParameter("id") != null)
			articleID = request.getParameter("id");
		else if(request.getAttribute("id") != null)
			articleID = request.getAttribute("id").toString();
		
		
		
		if (articleID.equals("")){
			//Set page Parameter.
			request.setAttribute("toModus", "error");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);			
		}
		else {
			HttpSession session = request.getSession(false);
			Member member = null;
			if (session != null)
				member = (Member) session.getAttribute("member");
			
			//Set Cookie to save that this article has been visited
			//First: Get recently visited Articles
			Cookie[] cookies = request.getCookies();
			
			Cookie watchedArticleCookie = null;
			String watchedArticleValue = "";
			
			for(int i=0; i < cookies.length; i++) {		
				Cookie c = cookies[i];
				if (c.getName().equals("watchedArticles")) {	
					watchedArticleCookie = c;
					watchedArticleValue = Details.decodeString(c.getValue());					
					
					//we can put the article ID to the end of the list
					if (watchedArticleValue.equals(""))
						watchedArticleValue += articleID.toString();
					else
					{
						boolean articleAlreadyInCookie = false;
						String[] articleIDs = watchedArticleValue.split(",");
						for(int y = 0; y < articleIDs.length ; y++){
							if (articleIDs[y].equals(articleID.toString())){
								articleAlreadyInCookie = true;
								break;
							}
						}
						if (!articleAlreadyInCookie)
						{
							// save only the 5 recently visited articles. 
							// The oldest is at the very beginning so 
							// we have to cut the String 
							
							//at first, check if there are more than 8 entries
							int numberOfCommas = watchedArticleValue.replaceAll("[^,]","").length();  
							if (numberOfCommas == 7){
								//delete first entry
								watchedArticleValue = watchedArticleValue.substring(watchedArticleValue.indexOf(',')+1);
							}
							
							watchedArticleValue += "," + articleID.toString();
						}
					}
				}
			}
			
			// set a new cookie
			if (watchedArticleCookie != null)
				watchedArticleCookie = new Cookie("watchedArticles", Details.encodeString(watchedArticleValue));
			else
				watchedArticleCookie = new Cookie("watchedArticles",Details.encodeString(articleID.toString()));	
			watchedArticleCookie.setMaxAge(30*24*60*60);
			response.addCookie(watchedArticleCookie);
			
			
			//Get Article Information
			if (DBCommands.GetArticleByID(Integer.parseInt(articleID)) != null)
				request.setAttribute("article", DBCommands.GetArticleByID(Integer.parseInt(articleID)));
			
			
			//Get ratings for this article, made by other members
			
			Collection<Rating> ratingsFromOthers = null;
			
			if (member != null)
				ratingsFromOthers = DBCommands.GetArticleRatingsFromOthersByArticleID(Integer.parseInt(articleID), member.GetMemberID());
			else
				ratingsFromOthers = DBCommands.GetArticleRatingsFromOthersByArticleID(Integer.parseInt(articleID), 0);
			
			if (ratingsFromOthers != null)
				request.setAttribute("ratings", ratingsFromOthers);
			
			//Get the rating for this article, made by the member who is logged in at the moment//
			
			if (member != null){
				// Member is logged in
				if (DBCommands.GetArticleRatingFromMemberByArticleID(Integer.parseInt(articleID), member) != null)
					request.setAttribute("ownRating", DBCommands.GetArticleRatingFromMemberByArticleID(Integer.parseInt(articleID), member));
			}
			
			
			//Get the average Rating for this article		
			request.setAttribute("sumRating", DBCommands.GetArticlesAverageRatingByID(Integer.parseInt(articleID)));
			
			
			//Set page Parameter.
			request.setAttribute("toModus", "details");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String givenRate = request.getParameter("givenRate");
		String ratingComment = request.getParameter("ratingComment");
		String articleID = request.getParameter("articleID");
		
		//Save rating
		try{
			if (Integer.parseInt(givenRate.trim()) <1 || Integer.parseInt(givenRate.trim()) > 5){
				//member has entried the wrong value (can only be done by manipulating the browser
				
				//Set page Parameter.
				request.setAttribute("toModus", "error");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				HttpSession session = request.getSession(false);
				Member member = null;
				if (session != null)
					member = (Member) session.getAttribute("member");
				
				//At first, check if there is already an entry of this member for this article
				if (DBCommands.HasMemberAlreadyARateForThatArticle(Integer.parseInt(articleID), member.GetMemberID())){
					// we need to update the rating
					DBCommands.updateArticleRatingByID(Integer.parseInt(articleID), member.GetMemberID(), ratingComment.trim(), Integer.parseInt(givenRate));
					
				}
				else{
					//no rate given yet.. insert a new one
					DBCommands.InsertArticleRatingByID(Integer.parseInt(articleID), member.GetMemberID(), ratingComment.trim(), Integer.parseInt(givenRate));
					
				}
				
			}
		}
		catch(Exception e){
			
		}
		
		
		request.setAttribute("id", request.getParameter("articleID"));
		this.doGet(request, response);
		
	}

}
