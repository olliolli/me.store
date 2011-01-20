package OrderManagement;

/*
Anlagedatum: 18.01.2011
Angelegt von: Falzer, Marcel

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Funktionsbeschreibung: Beschreibung des Objektes "OrderLine"

* */
public class OrderLine {
	private int orderID;
	private int articleID;
	private int amount;
	private double price;
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @return the articleID
	 */
	public int getArticleID() {
		return articleID;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param articleID the articleID to set
	 */
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
