/*
Anlagedatum: 13.01.2011
Angelegt von: Falzer, Marcel

�NDERUNGSHISTORIE
�nderungsdatum | Ge�ndert von | �nderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "CheckLogin"
                                  CheckLogin �berpr�ft, ob der Benutzer 
                                  angelegt ist. 

* */ 
package MemberManagement;
import DBConnection.DBCommands;
public class MemberLogin {
	/**
	 * @author Falzer,Marcel
	 * @version 1.1
	 * @return value, if the Login is successful:boolean
	 */
	
	public static Member returnMember(String eMail, String pwdHash){
		Member member = DBCommands.SelectMemberByEMailAndPwdHash(eMail, pwdHash);
//		if(DBCommands.SelectMemberByEMailAndPwdHash(eMail,pwdHash) != -1)
//			return true;
//		else
//			return false;		
		return member;
	}
	
	

}