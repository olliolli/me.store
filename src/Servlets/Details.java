package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.Rating;
import ArticleManagement.MediumType;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleID = request.getParameter("id");
		HttpSession session = request.getSession(false);
		Member member = null;
		if (session != null)
			member = (Member) session.getAttribute("member");
		
		
		
		//_______ BEGINN _____ Get article information______//
		
		String selectStatement = "select " +
			"ArticleID" +
			",mediumtype.Description" +
			",genre.GenreName" +
			",Title" +
			",art.Description" +
			",Price" +
			",Discount" +
			",Picture" +
			" from article art,mediumtype,genre";

		selectStatement += "" +
			" where art.MediumTypeID = mediumtype.MediumTypeID" +
			" and art.GenreID = genre.GenreID";		
		
		selectStatement += 
			" and art.ArticleID = " + articleID;
		
		System.out.println(selectStatement);
		
		ArrayList<String[]> rs = DBControl.ExecuteQuery(selectStatement);
		Article article = null;
		if (rs != null) {
			String[] element =  rs.get(0);
			article = new Article(
		  				Integer.parseInt(element[0]), 
		  				MediumType.valueOf(element[1]), 
		  				Genre.valueOf(element[2]), 
		  				element[3],
		  				element[4], 
				        Double.parseDouble(element[5]),				        
				        (int)Double.parseDouble(element[6]), 
				        element[7]
		  		);
		  		
		  	
		}
		
		request.setAttribute("article", article);
		
		//_______ END _____ Get article information______//
		
		
		
		//_______ BEGINN _____ Get article ratings______//
		
		String selectStatementRating = "select " +
			"member.FirstName" +
			", member.LastName" +
			", Rating" +
			", Comment" +
			", Date" +
			" from rating, member";

		selectStatementRating += " where rating.MemberID = member.MemberID";		
		selectStatementRating += 	" and rating.ArticleID = " + articleID;
		if (member !=null )
			selectStatementRating += 	" and rating.MemberID != " + member.GetMemberID();		
		
		System.out.println(selectStatementRating);
		
		Collection<Rating> ratings =  new ArrayList<Rating>();		
		
		ArrayList<String[]> rsRating = DBControl.ExecuteQuery(selectStatementRating);
		
		if (rsRating != null) {
		  	for (Iterator<String[]> iter = rsRating.iterator(); iter.hasNext();) {
		  		String[] element = (String[]) iter.next();
		  		ratings.add(new Rating(
		  				element[0], 
		  				element[1], 
		  				Integer.parseInt(element[2]),
		  				element[3],
		  				element[4]
		  		));
		  		
		  	}
		}
		
		request.setAttribute("ratings", ratings);
		
		//_______ END _____ Get article ratings______//
		
		
		//_______ BEGINN _____ Get article summary rating______//
		
		String selectStatementSummaryRating = "select " +
			"Round(AVG(rating),1)" +
			" from rating" +
			" where rating.ArticleID = " + articleID;
				
		System.out.println(selectStatementSummaryRating);
			
		double sumRating = 0.0;
		ArrayList<String[]> rsSummaryRating = DBControl.ExecuteQuery(selectStatementSummaryRating);
		
		if (rsSummaryRating != null) {
		  	for (Iterator<String[]> iter = rsSummaryRating.iterator(); iter.hasNext();) {
		  		String[] element = (String[]) iter.next();
		  		if (element[0] != null)
		  			sumRating = Double.parseDouble(element[0]);		  		
		  	}
		}
		
		request.setAttribute("sumRating", sumRating);
		
		//_______ END _____ Get article summary rating______//
		
		
		//_______ BEGINN _____ Get article logged in member's rating______//
		
		if (member != null){
			// Member is logged in
		
		
			String selectStatementOwn = "select " +
				"rating, comment, date" +
				" from rating" +
				" where rating.ArticleID = " + articleID +
				" and rating.MemberID = " + member.GetMemberID();
					
			System.out.println(selectStatementOwn);
				
			ArrayList<String[]> rsOwnRating = DBControl.ExecuteQuery(selectStatementOwn);
			
			Rating ownRating = null;
			
			if (rsOwnRating != null) {
			  	for (Iterator<String[]> iter = rsOwnRating.iterator(); iter.hasNext();) {
			  		String[] element = (String[]) iter.next();
			  		 		ownRating = new Rating(
			  		 				member.GetFirstName(), 
					  				member.GetLastName(), 
					  				Integer.parseInt(element[0]),
					  				element[1],
					  				element[2]
			  		 		);		  		 		
			  	}
			}
			
			request.setAttribute("ownRating", ownRating);
		}
		//_______ END _____ Get article logged in member's rating______//
		
		
		
		
		//Set page Parameter.
		request.setAttribute("toModus", "details");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
