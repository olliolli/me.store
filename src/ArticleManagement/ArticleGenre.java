/**
 * 
 */
package ArticleManagement;
/*
Anlagedatum: 10.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "ArticleGenre"
                                  Der Enum "Genre" wird hier zu einem String convertiert.
                                  Die ID wird zugeordnet.

* */
public class ArticleGenre {
	
	private String genreName;
	private int genreID;
	
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the genreName:String
	 */
	public String GetGenreName() {
		return genreName;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @param the genre:enum "Genre" of the article
	 */
	public void SetGenreName(Genre genre) {		
		this.genreName = genre.toString();	
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the genreID:integer
	 */
	public int GetGenreID() {
		
		return genreID;
	}	

}
