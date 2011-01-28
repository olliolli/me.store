package ArticleManagement;
/*
Anlagedatum: 10.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "Article"
                                  Zur Anlage einer Objektinstanz ist der Zugriff auf
                                  die Enums "Genre" und "MediumType" notwendig

* */ 
public class Article {
private int articleID;
private MediumType mediumType;
private Genre genre;
private String title;
private String description;
private double price;
private int discount;
private String picturePath;

public Article(){
	
}
/**
 * @author Strotmeier, Oliver
 * @version 1.0
 * @param toDo...
 */
public Article(int articleID, MediumType mediumType, Genre genre, String title,
		String description, double price, int discount, String picturePath) {
	super();
	this.articleID = articleID;
	this.mediumType = mediumType;
	this.genre = genre;
	this.title = title;
	this.description = description;
	this.price = price;
	this.discount = discount;
	this.picturePath = picturePath;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the articleID:integer
 */
public int GetArticleID() {
	return articleID;
}
/**
 * @author Falzer, Marcel
 * @version 1.0
 * @param articleID:Integer, set the articleID of the article 
 */
public void SetArticleID(int articleID){
	this.articleID = articleID;
}

/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the mediumType:enum "MediumType"
 */
public MediumType GetMediumType() {
	return mediumType;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param mediumType:enum "Mediumtype", set the mediumType of the article 
 */
public void SetMediumType(MediumType mediumType) {
	this.mediumType = mediumType;
}

/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the genre:enum "Genre"
 */
public Genre GetGenre() {
	return genre;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param genre:enum "Genre", set the genre of the article 
 */
public void SetGenre(Genre genre) {
	this.genre = genre;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the title of the article:String
 */
public String GetTitle() {
	return title;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param title:String, set the title of the article 
 */
public void SetTitle(String title) {
	this.title = title;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the description of the article:String
 */
public String GetDescription() {
	return description;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param description:String, set the description of the article 
 */
public void SetDescription(String description) {
	this.description = description;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the price:double
 */
public double GetPrice() {
	return price;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param price:double, set the price of the article 
 */
public void SetPrice(double price) {
	this.price = price;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the discount:int
 */
public int GetDiscount() {
	return discount;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param discount:integer, set the discount of the article 
 */
public void SetDiscount(int discount) {
	this.discount = discount;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @return the picturePath:String
 */
public String GetPicturePath() {
	return picturePath;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @param picturePath:String, set the picturePath of the article 
 */
public void SetPicturePath(String picturePath) {
	this.picturePath = picturePath;
}


}

