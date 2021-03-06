package DBConnection;
import java.util.ArrayList;
import javax.naming.ServiceUnavailableException;
import MemberManagement.*;
import DBConnection.*;

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
	
	public static void main(String[] args) throws ServiceUnavailableException {
		// -----------------------------Standard Test------------------------------
//		ArrayList<String[]> result = DBControl.ExecuteQuery("Select * from member");//		
//		for (int i = 0; i < result.size();i++){
//			for (int j = 0; j < result.get(i).length;j++){
//				System.out.print(result.get(i)[j]+";");
//			}
//			System.out.println();
//			
//		}
		//------------------------------Methodentest Marcel-------------------------
//		DBCommands cmd = new DBCommands();
//		System.out.println(cmd.SelectMemberByEMailAndPwdHash("user1@mail.de", "24c9e15e52afc47c225b757e7bee1f9d"));
//		if(CheckLogin.returnValue("user1@mail.de", "24c9e15e52afc47c225b757e7bee1f9d"))
//			System.out.println("Es funzt schon wieder");
//		System.out.println(DBCommands.SelectOpenOrderByMemberID(2).getOrderID());
//		int memberID = 2;
//		String SqlStatement = 
//			"Select * " +
//			"From buchclub.order " +
//			"Where `isalreadyordered` = 0 " +
//			"And `memberid` = " + memberID + ";";
//		ArrayList<String[]> results = DBControl.ExecuteQuery(SqlStatement);
//		System.out.println(results.get(0)[0]);
		System.out.println(DBCommands.SelectArticleByID(10).GetArticleID());
		//------------------------------Methodentest Steffi------------------------
		// eingegebene Parameter in Registrierungsformular holen und Variablen belegen
//		String firstName = "Steffi";
//		String lastName = "Muster";
//		String eMail = "Steffi@Test.de";
//		String city = "Guetersloh";
//		String postCode = "33335";
//		String street = "Musterweg 03";
//		String hnr = "5a";
//		String passwordHash = "Baumhaus007";
//		// Das eingegebene Passwort validieren ( min 8 Zeichen inkl. min 2 Zahlen)
//		boolean passwordCheck = MemberRegistration.ValidatePassword(passwordHash);
//		Role memberRole = Role.Member;
//	
//		if(passwordCheck==true){
//			try {
//				//Das eingegebene Passwort wird in einen Hashwert überführt
//				PasswordService ps = PasswordService.getInstance();
//				String passwordHashNew = ps.Encrypt(passwordHash);
//				// Alle Parameter werden an RegistrateUser übergeben und der User wird gepseichert.
//				MemberRegistration.RegistrateUser(firstName, lastName, eMail, street, hnr, postCode, city, passwordHashNew, memberRole);
//			} catch (ServiceUnavailableException e) {
//				e.printStackTrace();
//			}
//		}
//		else{
//			System.out.println("Das Passwort muss 8 Zeichen lang sein und min. 2 Zahlen enthalten");
//		}
//		Member member = new Member();
//		member.SetCity("TestStadt");
//		member.SetEMail("TestMail@test.de");
//		member.SetFirstName("Test");
//		member.SetLastName("User");
//		member.SetMemberRole(Role.Member);
//		member.SetPasswordHash(PasswordService.getInstance().Encrypt("Maus007"));
//		member.SetPostCode("33335");
//		member.SetStreet("Teststreet");
//		member.SetStreetNumber("5a");				
//		DBCommands.InsertMember(member);
//		if(MemberRegistration.ValidatePassword("Schlumpfine03")==false){
//			System.out.println("Falsches Passwort");
//		}
//		else{
//			 int returnValue = MemberRegistration.RegistrateUser("Schlaubi", "Schlumpf", "Schlumpfig@SH.de", "Schlumpfhausenweg", "222", "22222", "Schlumpfhause", PasswordService.getInstance().Encrypt("Schlumpfine03"), Role.Member);
//				System.out.println(returnValue);
//		}
	   
		
	}

}
