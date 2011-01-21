/*
Anlagedatum: 13.01.2011
Angelegt von: Falzer, Marcel

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "DBCommands"
                                  DBCommands beinhaltet die SQL-Anweisungen 
                                  für einen Datenbankzugriff

 * */
package DBConnection;
import java.util.ArrayList;

import MemberManagement.Member;
import MemberManagement.Role;
import OrderManagement.Order;
import OrderManagement.OrderLine;

public class DBCommands {
	/**
=======
import MemberManagement.*;
import javax.management.relation.Role;

/**
>>>>>>> 7f3fce6c37a9a467500d46a27cff5666073131f9
	 * @author Falzer, Marcel
	 * @version 0.1
	 * @param eMail-adress of the user:string, hashvalue of password of user:string
	 * @return memerId of user or -1 when user not registrated: int
	 */
	public  static int SelectMemberByEMailAndPwdHash(String eMail, String pwdHash){
		int memberID=-1;
	    String sql = "Select MemberId from member where EMail like '"+eMail+"' and PasswordHash like '"+pwdHash+"';"; 
		try{
		
		memberID = Integer.parseInt(DBControl.ExecuteQuery(sql).get(0)[0]);
		}
		catch(Exception e){
		}
		return memberID;
	}

	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param eMail
	 * @return returns the eMail address of the member. If the member has no email address the method returns an empty String.
	 */
	public static String SelectMemberByEMail(String eMail) {
		String MembersMail="";
		String sql = "Select EMail from Member where EMail="+eMail;
		try{
			MembersMail = DBControl.ExecuteQuery(sql).get(0)[0];	

		}
		catch(Exception e){
		}
		return MembersMail;				
	}

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
			member.SetPassword(results.get(0)[8]);		
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
	 * @param member
	 * @return returns no value because the method inserts a new registrated User.
	 */
//	public static Member SelectUserData(int userId) {
//		String sql = "Select * from member where " + userId + ";";
//		ArrayList<String[]> result = DBControl.ExecuteQuery(sql);
//		Role r;
//		
//		Member m = new Member(result.get(0)[9], result.get(0)[1],
//				result.get(0)[2], result.get(0)[7], result.get(0)[3],
//				result.get(0)[4], result.get(0)[5], result.get(0)[6],
//				Integer.getInteger(result.get(0)[0]), result.get(0)[8]);
//
//		return m;
//	}
	public static void InsertMember(Member member) {
		DBControl Ctrl = new DBControl();
		int MemberID=1;
	    
		if(member.GetMemberRole().toString()=="admin"){
	    	MemberID=2;
	    }
		
		String SqlStatement = "Insert into member "+
				              "(firstName,lastName, street, nr, postcode, city, email, passwordhash, roleid) values " 
			                  +"('"+member.GetFirstName()+"','"
				              +member.GetLastName()+"','"
				              +member.GetStreet()+"','"
				              +member.GetStreetNumber()+"','"
				              +member.GetPostCode()+"','"
				              +member.GetCity()+"','"
				              +member.GetEMail()+"','"
				              +member.GetPassword()+"',"
				              +MemberID+")";
		try{
			Ctrl.ExecuteQuery(SqlStatement);	
		}
		catch(Exception e){
			
		}				
	}

/**
 * @author Henning, Roy
 * @version 0.1
 * @param Member Object
 * no return value
 */
public static void UpdateMember(Member member) {
	DBControl Ctrl = new DBControl();
	String SqlStatement = "UPDATE `buchclub`.`member` " + "SET "
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
	Ctrl.ExecuteQuery(SqlStatement);
}
	public static void NewOrder(Order order){
		String SqlStatement = "Insert into order(memberid) values ('" + order.getMember().GetMemberID() + "');";
		DBControl.ExecuteQuery(SqlStatement);	
	}
	public static void NewOrderLine(OrderLine orderLine){
		String SqlStatement = 
			"Insert into orderline(orderid,articleid,amount,price) " +
			"values ('" + orderLine.getOrderID() + "'," +
					"'" + orderLine.getArticleID() + "'," +
					"'" + orderLine.getAmount() + "'," +
					"'" + orderLine.getPrice() + "');";
		DBControl.ExecuteQuery(SqlStatement);
	}
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
		}
		return orderLines;
	}
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
		}
		return order;
	}
	public static void AcceptOrder(Order order){
		String SqlStatement = 
			"Update order(isalreadyordered = 1," +
			"orderdate = today " +
			"Where orderid = " + order.getOrderID();
		DBControl.ExecuteQuery(SqlStatement);
			
	}
	

	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1 
	 * @param Member Object
	 */
	public static void UpdateUserPassword(Member member) {
		DBControl Ctrl = new DBControl();
		String SqlStatement = "UPDATE `buchclub`.`member` " + "SET "
				+ "`psswordhash`= '" + member.GetPassword() + "'"
				+ "WHERE `MemberID`='" + member.GetMemberID() + "';";
		Ctrl.ExecuteQuery(SqlStatement);
	}

}
