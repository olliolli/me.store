package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.MediumType;
import DBConnection.DBControl;

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
		
		//Set page Parameter.
		request.setAttribute("toModus", "details");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
