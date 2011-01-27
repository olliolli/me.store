package ArticleManagement;
/*
creation date: 10.01.2011
created by: Grunewald, Stephanie

HISTORY OF MODIFICATION
=============================================================================
modification date  | modified from     | description | version number
-----------------------------------------------------------------------------
15.01.2011         Strotmeier, Oliver  add constructor  1.0

decription of the main function:  description of the objects of "Article".

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

/**
 * @author Strotmeier, Oliver
 * @version 1.0
 * @see Genre
 * @see MediumType
 * @since 15.01.2011
 * @param articleID - (INTEGER) the identification number of the article
 * @param mediumType - (Enum MEDIUMTYPE) the type of the medium (DVD, BluRay, Buch, eBook, Musik, GamePlayStation1, GamePlayStation2, GameNintendoWii, Film)
 * @param genre - (Enum GENRE) the genre of the article (Horror, Fantasy,	ScienceFiction,	Komödie, Action, Western, Pop )
 * @param title - (STRING) the title of the article
 * @param description - (STRING) the description of the article
 * @param price - (DOUBLE) the price of the article
 * @param discount - (INT) the discount of the article
 * @param picturePath - (STRING) the path of the location where the original picture of the article is located
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
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return articleID - (INTEGER) the identification number of the article
 */
public int GetArticleID() {
	return articleID;
}

/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @see MediumType
 * @since 10.01.2011
 * @return mediumType - (Enum MEDIUMTYPE) the type of the medium (DVD, BluRay, Buch, eBook, Musik, GamePlayStation1, GamePlayStation2, GameNintendoWii, Film)
 */
public MediumType GetMediumType() {
	return mediumType;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @see MediumType
 * @since 10.01.2011
 * @param mediumType - (Enum MEDIUMTYPE) the type of the medium (DVD, BluRay, Buch, eBook, Musik, GamePlayStation1, GamePlayStation2, GameNintendoWii, Film)
 */
public void SetMediumType(MediumType mediumType) {
	this.mediumType = mediumType;
}

/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @see Genre
 * @since 10.01.2011
 * @return genre - Enum GENRE) the genre of the article (Horror, Fantasy, ScienceFiction, Komödie, Action, Western, Pop )
 */
public Genre GetGenre() {
	return genre;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @see Genre
 * @since 10.01.2011
 * @param genre - Enum GENRE) the genre of the article (Horror, Fantasy,	ScienceFiction,	Komödie, Action, Western, Pop )
 */
public void SetGenre(Genre genre) {
	this.genre = genre;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return title - (STRING) the title of the article
 */
public String GetTitle() {
	return title;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @param title - (STRING) the title of the article
 */
public void SetTitle(String title) {
	this.title = title;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return description - (STRING) the description of the article
 */
public String GetDescription() {
	return description;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @param description - (STRING) the description of the article 
 */
public void SetDescription(String description) {
	this.description = description;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return price - (DOUBLE) the price of the article
 */
public double GetPrice() {
	return price;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @param price - (DOUBLE) the price of the article 
 */
public void SetPrice(double price) {
	this.price = price;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return discount - (INT) the discount of the article
 */
public int GetDiscount() {
	return discount;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @param discount - (INT) the discount of the article 
 */
public void SetDiscount(int discount) {
	this.discount = discount;
}
/**
 * @author Grunewald,Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @return picturePath - (STRING) the path of the location where the original picture of the article is located
 */
public String GetPicturePath() {
	return picturePath;
}
/**
 * @author Grunewald, Stephanie
 * @version 1.0
 * @since 10.01.2011
 * @param picturePath - (STRING) the path of the location where the original picture of the article is located 
 */
public void SetPicturePath(String picturePath) {
	this.picturePath = picturePath;
}


}

