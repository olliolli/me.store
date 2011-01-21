package DBConnection;

import java.util.ArrayList;


/*
Anlagedatum: 13.01.2011
Angelegt von: Falzer, Marcel

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung | Versionsnummer
----------------------------------------------------------------------

Allgemeine Funktionsbeschreibung: Beschreibung des Objektes "DBControlTest"
                                  DBControlTest dient dem Testen der Klasse
                                  DBControl

* */ 



public class DBControlTest {
	
	public static void main(String[] args) {
		ArrayList<String[]> result = DBControl.ExecuteQuery("Select * from member where firstName like 'User'");
		for (int i = 0; i < result.size();i++){
				for (int j = 0; j < result.get(i).length;j++){
					System.out.print(result.get(i)[j]+";");
				}
				System.out.println();		
		}
//		DBCommands cmd = new DBCommands();
//		System.out.println(cmd.SelectMemberByEMailAndPwdHash("user1@mail.de", "24c9e15e52afc47c225b757e7bee1f9d"));
//		if(CheckLogin.returnValue("user1@mail.de", "24c9e15e52afc47c225b757e7bee1f9d"))
//			System.out.println("Es funzt schon wieder");
//		System.out.println(DBCommands.SelectOpenOrderByMemberID(2).getOrderID());
//		String password = "password";
//		String firstName = "Test";
//		String lastName = "User";
//		String eMail = "Test@User.de";
//		String street = "Testweg";
//		String city = "Testhause";
//		String hnr = "22";
//		String postCode = "12345";
//		Role memberRole = Role.Member;		
//		int checkValue = MemberRegistration.RegistrateUser(firstName, lastName, eMail, street, hnr, postCode, city, password, memberRole);

	}

}
