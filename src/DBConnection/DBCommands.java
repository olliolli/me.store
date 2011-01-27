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
import OrderManagement.*;

public class DBCommands {

/**    
 	 * @author Falzer, Marcel
	 * @version 1.0
	 * @see Member
	 * @see DBControl
	 * @since 14.01.2011
	 * @exception Exception 
	 * @param eMail - (STRING) the eMail address of the member
	 * @param pwdHash - (STRING) the hash value of password of the member
	 * @return member - (object MEMBER) the member as the result of the search
	 */
	public static Member SelectMemberByEMailAndPwdHash(String eMail, String pwdHash){
		Member member = new Member();
	    String sql = "Select MemberID from member where EMail like '"+eMail+"' and PasswordHash like '"+pwdHash+"';"; 
		try{
			int memberID = Integer.parseInt(DBControl.ExecuteQuery(sql).get(0)[0]);
			member = DBCommands.SelectMemberByID(memberID);		
		}
		catch(Exception e){
		}
		return member;
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
			ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
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
		}
		catch(Exception e){
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
				+ "'"
				+ "`lastname`= '"
				+ member.GetLastName()
				+ "'"
				+ "`street`= '"
				+ member.GetStreet()
				+ "'"
				+ "`nr`= '"
				+ member.GetStreetNumber()
				+ "'"
				+ "`postcode`= '"
				+ member.GetPostCode()
				+ "'"
				+ "`city`= '"
				+ member.GetCity()
				+ "'"
				+ "`email`= '"
				+ member.GetEMail()
				+ "'"
				+ "WHERE `MemberID`='" + member.GetMemberID() + "';";
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
			"From order " +
			"Where isalreadyordered = 0 " +
			"And memberid = '" + memberID + "';";
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
		catch(Exception e){
			System.out.println(e);
		}		
	}
}
