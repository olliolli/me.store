/*
creation date: 13.01.2011
created by: Falzer, Marcel

HISTORY OF MODIFICATION
=============================================================================
modification date  | modified from          | description            | version number
-----------------------------------------------------------------------------

decription of the main function:  the methods realizing the login function

* */ 
package MemberManagement;
import DBConnection.DBCommands;
public class MemberLogin {
	/**
	 * @author Falzer,Marcel
	 * @version 1.0
	 * @since 13.01.2011
	 * @return member - (object MEMBER) the member object which was found by the execution of the sql statement of dbcommands
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
