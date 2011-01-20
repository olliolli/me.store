package ArticleManagement;
/*
Anlagedatum: 10.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "ArticleMediumType"
                                  Der Enum "MediumType" wird hier zu einem String convertiert.
                                  Die ID wird zugeordnet.

* */ 
public class ArticleMediumType {
	private String mediumTypeDescription;
	
	private int mediumTypeID;
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the mediumTypeDescription:String
	 */
	public String GetMediumTypeDescription() {
		return mediumTypeDescription;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @param the mediumType:enum "MediumType" of the article
	 */
	public void SetMediumTypeDescription(MediumType mediumType) {
		this.mediumTypeDescription = mediumType.toString();
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the mediumTypeID:integer
	 */
	public int getMediumTypeID() {
		return mediumTypeID;
	}
	
}

