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

import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.MediumType;
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
		
		ArrayList<String> params = new ArrayList<String>();

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
		
		selectStatement += 
				" where art.MediumTypeID = mediumtype.MediumTypeID" +
				" and art.GenreID = genre.GenreID";
		
		if (rsOption != null && rsOption.equals("Neu")){
			selectStatement += " and exists ( select count(*) from" +
			" article a where a.createdDate > art.createdDate" +
			" having count(*) < 10 )";				
		}
		else
			if (rsMedium != null || rsCategory != null || rsOption != null || rsSearchQuery != null)
			{	
				selectStatement += " and (";
				if (rsMedium != null && !rsMedium.equals("")){
					
					selectStatement += " mediumtype.Description like '";
					//params.add(rsMedium);
					selectStatement += rsMedium;
					selectStatement += "' and";
				}
				if (rsCategory != null && !rsCategory.equals("")){
					selectStatement += " genre.GenreName like '";
					//params.add(rsCategory);
					selectStatement += rsCategory;
					selectStatement += "' and";
				}
				if (rsOption != null && !rsOption.equals("")){
					
						if(rsOption.equals("Reduziert")){
						selectStatement += " Discount != 0.00";
						selectStatement += " and";
					}
				}
				if (rsSearchQuery != null && !rsSearchQuery.equals("")){	
					Integer intSearchQuery = -1;
					try{
						intSearchQuery = Integer.parseInt(rsSearchQuery);
						selectStatement += " art.ArticleID = ";
						selectStatement += rsSearchQuery;
						selectStatement += " and";
					}
					catch(NumberFormatException e){
						rsSearchQuery.toUpperCase();
						selectStatement += " UPPER(art.Title) like '%";
						selectStatement += rsSearchQuery;
						selectStatement += "%' and";
					}					
				}			
				
				selectStatement = selectStatement.substring(0, selectStatement.length() - 4);
				selectStatement += " )";
			}
		
		
		System.out.println(selectStatement);
		
		
		Collection<Article> collection =  new ArrayList<Article>();
		
		
		ArrayList<String[]> rs = DBControl.ExecuteQuery(selectStatement,params);
		
		if (rs != null) {
		  	for (Iterator<String[]> iter = rs.iterator(); iter.hasNext();) {
		  		String[] element = (String[]) iter.next();
		  		collection.add(new Article(
		  				Integer.parseInt(element[0]), 
		  				MediumType.valueOf(element[1]), 
		  				Genre.valueOf(element[2]), 
		  				element[3],
		  				element[4], 
				        Double.parseDouble(element[5]),				        
				        (int)Double.parseDouble(element[6]), 
				        element[7]
		  		));
		  		
		  	}
		}
		
		/*
		
		
		Collection<Article> collection = new ArrayList<Article>();
		collection.add(new Article(1, MediumType.eBook, Genre.Action, "actionbook",
				"This is an action book", 12.94, 5, "images/products/buecher/Harry_Potter.jpg"));
		collection.add(new Article(1, MediumType.eBook, Genre.Horror, "doku",
				"This is a horror book", 8.94, 0, "images/products/buecher/Harry_Potter.jpg"));
		collection.add(new Article(1, MediumType.eBook, Genre.Phantasy, "Peter Pan",
				"The life of peter Pan", 212.94, 20, "images/products/buecher/Harry_Potter.jpg"));
				
		*/
				
		//Set article List
		request.setAttribute("articles", collection);
		
		//Set search Parameter to show it in the header line of the search result
		request.setAttribute("med", rsMedium);
		request.setAttribute("cat", rsCategory);
		request.setAttribute("opt", rsOption);
		
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
