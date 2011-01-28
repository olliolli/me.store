package OrderManagement;

import java.util.ArrayList;

import MemberManagement.Member;
import ArticleManagement.Article;

/*
Anlagedatum: 10.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Funktionsbeschreibung: Beschreibung des Objektes "Order"

* */
public class Order {
	private int orderID;
	private Member member;
	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	private boolean isAlreadyOrdered;
	private String orderDate;
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the member object:Member
	 */
	public Member getMember() {
		return member;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param member object:Member, set the member of the order
	 */
	public void setMember(Member member) {
		this.member = member;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the List of orderLines:arraylist
	 */
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param orderline:arraylist, set the orderlines a member has ordered or wants to order
	 */
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the value if the order has been transacted:boolean
	 */
	public boolean getIsAlreadyOrdered() {
		return isAlreadyOrdered;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param value if the order has been transacted:boolean, set the status value of the order
	 */
	public void setAlreadyOrdered(boolean isAlreadyOrdered) {
		this.isAlreadyOrdered = isAlreadyOrdered;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the orderDate:String
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param orderDate:String, set the orderDate of the order
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the orderID:integer
	 */
	public int getOrderID() {
		return orderID;
	}	
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param orderID:Integer, set the orderID of the order
	 */
	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
}
