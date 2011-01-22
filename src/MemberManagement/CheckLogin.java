/*
Anlagedatum: 13.01.2011
Angelegt von: Falzer, Marcel

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "CheckLogin"
                                  CheckLogin überprüft, ob der Benutzer 
                                  angelegt ist. 

* */ 
package MemberManagement;
import DBConnection.DBCommands;
public class CheckLogin {
	/**
	 * @author Falzer,Marcel
	 * @version 1.0
	 * @return value, if the Login is successful:boolean
	 */
	
	public static int returnValue(String eMail, String pwdHash){
		int userID = DBCommands.SelectMemberByEMailAndPwdHash(eMail, pwdHash);
//		if(DBCommands.SelectMemberByEMailAndPwdHash(eMail,pwdHash) != -1)
//			return true;
//		else
//			return false;		
		return userID;
	}
	
	

}
