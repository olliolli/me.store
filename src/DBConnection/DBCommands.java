/*
creation date: 14.01.2011
created by: Falzer, Marcel

HISTORY OF MODIFICATION
=============================================================================
modification date | modified from | description | version number
-----------------------------------------------------------------------------
 20.01.2011         Henning, Roy    updateUserPassword       1.1

decription of the main function:  methods which include different sql statements to manipulate or select data.

* */

package DBConnection;
import java.util.ArrayList;
import MemberManagement.*;
import ArticleManagement.Article;
import ArticleManagement.Genre;
import ArticleManagement.MediumType;
import MemberManagement.Member;
import MemberManagement.Role;
import OrderManagement.Order;
import OrderManagement.OrderLine;

public class DBCommands {

	/**
 	 * @author Falzer, Marcel
	 * @version 1.3
	 * @see Member
	 * @return member object or null when user registrated: member
	 * @see DBControl
	 * @since 14.01.2011
	 * @exception Exception 
	 * @param eMail - (STRING) the eMail address of the member
	 * @param pwdHash - (STRING) the hash value of password of the member
	 * @return member - (object MEMBER) the member as the result of the search
	 */
	public static Member SelectMemberByEMailAndPwdHash(String eMail, String pwdHash){
		Member member = new Member();
	    String SqlStatement = "Select * from member where EMail like '"+eMail+"' and PasswordHash like '"+pwdHash+"';"; 
		try{
			member = DBCommands.FillMember(DBControl.ExecuteQuery(SqlStatement));
		}
		catch(Exception e){
		}
		return member;
	}
	/**
	* @author Falzer, Marcel
	 * @version 1.0
	 * @param list of results of a sqlstatement: ArrayList<String[]>
	 * @return member object or null when user is not registrated: member
	 */
	public static Member FillMember(ArrayList<String[]> results){
		Member member = new Member();
		
		member.SetMemberID(Integer.parseInt(results.get(0)[0]));
		member.SetFirstName(results.get(0)[1]);
		member.SetLastName(results.get(0)[2]);
		member.SetStreet(results.get(0)[3]);
		member.SetStreetNumber(results.get(0)[4]);
		member.SetPostCode(results.get(0)[5]);
		member.SetCity(results.get(0)[6]);
		member.SetEMail(results.get(0)[7]);
		member.SetPasswordHash(results.get(0)[8]);		
		if(Integer.parseInt(results.get(0)[9])==1)
			member.SetMemberRole(Role.Admin);
		else
			member.SetMemberRole(Role.Member);
		
		return member;
	}
	/**
	* @author Falzer, Marcel
	 * @version 1.0
	 * @param list of results of a sqlstatement: ArrayList<String[]>
	 * @return article object or null when article is not found: article
	 */
	public static Article FillArticle(ArrayList<String[]> results){
		Article article = new Article();
		
		article.SetArticleID(Integer.parseInt(results.get(0)[0]));
		article.SetMediumType(DBCommands.SelectMediumTypeByID(Integer.parseInt(results.get(0)[1])));
		article.SetGenre(DBCommands.SelectGenreByID(Integer.parseInt(results.get(0)[2])));
		article.SetTitle(results.get(0)[3]);
		article.SetDescription(results.get(0)[4]);
		article.SetPrice(Double.parseDouble(results.get(0)[5]));
		article.SetDiscount(Double.parseDouble(results.get(0)[6]));
		article.SetPicturePath(results.get(0)[7]);
		
		return article;
	}

	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @since 15.01.2011
	 * @exception Exception
	 * @param eMail - (STRING) the eMail address of the user who wants to registrate to me.store 
	 * @return membersMail - (STRING) the eMail which was found in the mySQL database.
	 */
	public static String SelectMemberByEMail(String eMail) {
		String membersMail="";
		String sql = "Select EMail from Member where EMail like '"+eMail+"';";
		try{
			membersMail = DBControl.ExecuteQuery(sql).get(0)[0].toString();	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return membersMail;				
	}

/** 
 * @author Falzer, Marcel
 * @version 1.0
 * @since 14.01.2011
 * @exception Exception
 * @param memberID - (STRING) the identification number of the member
 * @return member - (object MEMBER) the member as the result of the search
 */
	public static Member SelectMemberByID(int memberID){
		Member member = new Member();
		String SqlStatement = 
			"Select * " +
			"From member " +
			"Where memberid = " + memberID + ";";
		try{
			
			member = DBCommands.FillMember(DBControl.ExecuteQuery(SqlStatement));
			
		}
		catch(Exception e){
			System.out.println(SqlStatement);
		}
		return member;
	}
	
/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @since 15.01.2011
	 * @exception Exception
	 * @param member - (object MEMBER) the user who wants to get registrated
	 */
	public static void InsertMember(Member member) {
		//set the roleID
		int MemberID=1;	    
		if(member.GetMemberRole().toString()=="admin"){
	    	MemberID=2;
	    }
		 // the insert statement
		String sqlStatement = "Insert into member "+
				              "(firstName,lastName, street, nr, postcode, city, email, passwordhash, roleid) values " 
			                  +"('"+member.GetFirstName()+"','"
				              +member.GetLastName()+"','"
				              +member.GetStreet()+"','"
				              +member.GetStreetNumber()+"','"
				              +member.GetPostCode()+"','"
				              +member.GetCity()+"','"
				              +member.GetEMail()+"','"
				              +member.GetPasswordHash()+"',"
				              +MemberID+")";
		try{
			// execute the sqlStatement and set a checkValue
			ArrayList<String[]> checkValue = new ArrayList<String[]>();
			checkValue = DBControl.ExecuteQuery(sqlStatement);	
		}
		catch(Exception e){
			System.out.println(e);
		}				
	}

/**
	 * @author Henning, Roy
	 * @version 1.0
	 * @see DBControl
	 * @exception Exception
	 * @since 14.01.2011
	 * @param member - (object MEMBER) the member object of the member who wants to edit his/her personal data of the me.store
*/
public static void UpdateMember(Member member) {
		DBControl Ctrl = new DBControl();
		// the update statement
		String SqlStatement = "UPDATE member " + "SET "
				+ "`firstname`= '"
				+ member.GetFirstName()
				+ "', "
				+ "`lastname`= '"
				+ member.GetLastName()
				+ "', "
				+ "`street`= '"
				+ member.GetStreet()
				+ "', "
				+ "`nr`= '"
				+ member.GetStreetNumber()
				+ "', "
				+ "`postcode`= '"
				+ member.GetPostCode()
				+ "', "
				+ "`city`= '"
				+ member.GetCity()
				+ "', "
				+ "`email`= '"
				+ member.GetEMail()
				+ "' "
				+ "WHERE memberid = '" + member.GetMemberID() + "';";
		try{
			Ctrl.ExecuteQuery(SqlStatement);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @see DBControl
 * @since 16.01.2011
 * @param order - (object ORDER) the order object which should get inserted into the database
 */
	public static void NewOrder(Order order){
		String SqlStatement = "Insert into order(memberid) values ('" + order.getMember().GetMemberID() + "');";
		try{
			DBControl.ExecuteQuery(SqlStatement);	
		}
		catch(Exception e){
			System.out.println(e);
		}		
	}

	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @since 16.01.2011
	 * @exception Exception
	 * @see DBControl
	 * @param orderLine - (object ORDERLINE) the orderline object which should get inserted into the database
	 */
	public static void NewOrderLine(OrderLine orderLine){
		String SqlStatement = 
			"Insert into orderline(orderid,articleid,amount,price) " +
			"values ('" + orderLine.getOrderID() + "'," +
					"'" + orderLine.getArticleID() + "'," +
					"'" + orderLine.getAmount() + "'," +
					"'" + orderLine.getPrice() + "');";
		try{
			DBControl.ExecuteQuery(SqlStatement);
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @since 16.01.2011
 * @exception Exception
 * @param orderID - (INTEGER) the identification number of the order
 * @return orderLines - (ArrayList<ORDERLINE>) a list of all orderLines of the selected order
 */
	public static ArrayList<OrderLine> SelectOrderLines(int orderID){
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
		String SqlStatement = 
			"Select * " +
			"From orderline " +
			"Where orderid = '" + orderID + "';";
		try{
			ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
			for (int i = 0; i < results.size();i++){
				OrderLine orderLine = new OrderLine();
				orderLine.setOrderID(Integer.parseInt(results.get(i)[0]));
				orderLine.setArticleID(Integer.parseInt(results.get(i)[1]));
				orderLine.setAmount(Integer.parseInt(results.get(i)[2]));
				orderLine.setPrice(Double.parseDouble(results.get(i)[3]));
				orderLines.add(orderLine);
			}
		}
		catch (Exception e){
			System.out.println(SqlStatement);
			System.out.println(e);
		}
		return orderLines;
	}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @since 16.01.2011
 * @see DBControl
 * @exception Exception
 * @param memberID
 * @return
 */
	public static Order SelectOpenOrderByMemberID(int memberID){
		Order order = new Order();
		String SqlStatement = 
			"Select * " +
			"From buchclub.order " +
			"Where `isalreadyordered` = 0 " +
			"And `memberid` = " + memberID + ";";
		try{
			ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
			order.setOrderID(Integer.parseInt(results.get(0)[0]));
			order.setMember(DBCommands.SelectMemberByID(Integer.parseInt(results.get(0)[1])));
			order.setOrderDate(results.get(0)[3]);
			order.setOrderLines(DBCommands.SelectOrderLines(order.getOrderID()));
			if (Integer.parseInt(results.get(0)[4])== 1)
				order.setAlreadyOrdered(true);
			else
				order.setAlreadyOrdered(false);			
		}
		catch (Exception e){
			System.out.println(SqlStatement);
			System.out.println(e);
		}
		return order;
	}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @exception Exception
 * @since 16.01.2011	
 * @param order - (object ORDER) the order object which should get accepted
 */
	public static void AcceptOrder(Order order){
		String SqlStatement = 
			"Update order(isalreadyordered = 1," +
			"orderdate = today " +
			"Where orderid = " + order.getOrderID();
		try{
			DBControl.ExecuteQuery(SqlStatement);
		}
		catch(Exception e){
			System.out.println(e);
		}			
	}
	
	/**
	 * @author Henning, Roy
	 * @version 1.1 
	 * @since 20.01.2011
	 * @see DBControl
	 * @exception Exception
	 * @param member - (object MEMBER) the member object of the member who wants to edit his/her login password of the me.store 
	 */
	public static void UpdateUserPassword(Member member) {
		DBControl Ctrl = new DBControl();
		String SqlStatement = "UPDATE `buchclub`.`member` " + "SET "
				+ "`psswordhash`= '" + member.GetPasswordHash() + "'"
				+ "WHERE `MemberID`='" + member.GetMemberID() + "';";
		try{
			Ctrl.ExecuteQuery(SqlStatement);
		}
		catch(Exception e)
		{
		}
	}
	/**
	* @author Falzer, Marcel
	 * @version 1.0
	 * @param articleID: Integer
	 * @return article object or null when article is not found: article
	 */
	public static Article SelectArticleByID(int articleID){
		Article article = new Article();
		String SqlStatement =
			"Select * " +
			"From article " +
			"Where articleid = '"+articleID+"';";
		try{
			article = DBCommands.FillArticle(DBControl.ExecuteQuery(SqlStatement));
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println(SqlStatement);
		}
		
		return article;
	}
	/**
	* @author Falzer, Marcel
	 * @version 1.0
	 * @param mediumTypeID: Integer
	 * @return mediumType object or null when mediumType is not found: mediumType
	 */
	public static MediumType SelectMediumTypeByID(int mediumTypeID){
		MediumType mt = null;
		String SqlStatement = 
			"Select * " + 
			"From buchclub.mediumtype " + 
			"Where `mediumtypeid` = " + mediumTypeID + ";";
		try{
			ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
			mt = MediumType.valueOf(results.get(0)[1]);
			return mt;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return mt;
	}
	public static Genre SelectGenreByID(int genreID){
		Genre genre = null;
		String SqlStatement = 
			"Select * " + 
			"From buchclub.genre " + 
			"Where `genreid` = " + genreID + ";";
		try{
			ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
			genre = Genre.valueOf(results.get(0)[1]);
			return genre;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return genre;
	}
}

