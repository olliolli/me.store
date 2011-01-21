package MemberManagement;

import DBConnection.DBCommands;

/*
Anlagedatum: 13.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung                | Versionsnummer
--------------------------------------------------------------------------------------
17.01.2011      SG              Die Methoden ValidateMemberEMail            1.1
                                und IsAlwaysRegistrated wurden
                                erstellt um das Abspeichern von Dubletten
                                und falschen Daten zu verhindern
18.01-2011      SG              Die Methode ValidatePassword wurde erstellt 1.2
                                Die Methode ValidateMemberEMail wurde auf
                                public geändert
                                
Allgemeine Funktionsbeschreibung:Die Methode erstellt ein Member Objekt 
anhand der vom Controller übergebenen Parameter 
und greift anschließend auf die Methode zum Speichern des neuen Benutzers zu.
--> Dabei werden zunächst die vom Controller übergebenen Daten überprüft.
* */
public class MemberRegistration {
	
	/**
	 * @version 1.1
	 * @author Grunewald,Stephanie
	 * @param firstName :String = firstName of the member
	 * @param lastName :String = lastName of the member
	 * @param eMail :String = eMail address of the member
	 * @param city :String = city the member lives
	 * @param street :String = street of the member
	 * @param streetNumber :String = streetnumber of the member
	 * @param postCode :String = postcode of the city of the member
	 * @param password :String = login password of the member
	 * @param memberRole :enum = the role of the member (member or admin)
	 * @return 1 --> missing/false firstName or lastName, 
	 * 2 --> The member is already registrated,
	 * 3 --> The eMail address has a false validation
	 * 4 --> the password has not the size of 8 chars or contains less than 2 numbers 
	 * 0 --> SaveMember was successfull
	 */
	public static int RegistrateUser(String firstName,String lastName, String eMail, String street, String streetNumber, String postCode, String city, String password, Role memberRole){
			if(firstName.length()<2 || lastName.length()<2){
				return 1;
			}
			else if (MemberRegistration.IsAlwaysRegistrated(eMail)==true){
				return 2;
			}
//			else if (MemberRegistration.ValidateMemberEMail(eMail)==false){
//				return 3;
//			}
			else if(MemberRegistration.ValidatePassword(password)==false){
				return 4;
			}
			else{
				Member member = new Member();
				member.SetCity(city);
				member.SetEMail(eMail);
				member.SetFirstName(firstName);
				member.SetLastName(lastName);
				member.SetMemberRole(memberRole);
				member.SetPassword(password);
				member.SetPostCode(postCode);
				member.SetStreet(street);
				member.SetStreetNumber(streetNumber);
				
				DBCommands.InsertMember(member);
				
				return 0;
			}		
	}
	
	public static String GeneratePasswordHash(String password){
		String passwordHash="";
		return passwordHash;
	}
	
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param eMail :String = the eMail address of the member
	 * @return true --> if the member is already registrated, false --> if the member is even not registrated 
	 */
	private static boolean IsAlwaysRegistrated(String eMail){
		String membersEMail = DBCommands.SelectMemberByEMail(eMail);
		if(membersEMail!=""){
			return true;
		}
		else{
			return false;
		}		
	}
	
//	/**
//	 * @author: Grunewald Stephanie
//	 * @version: 1.1
//	 * @param memberEMail :String = the eMail address of the member
//	 * @return true --> if the eMail address has the correct format, false --> if the eMail address do not have the correct format
//	 */
//	public static boolean ValidateMemberEMail(String memberEMail){
//		String validationSchema = "(^([a-zA-Z0-9])+([\\.a-zA-Z0-9_-])*@([a-zA-Z0-9_-])+(\\.[a-zA-Z0-9_-]+)+";
//		Pattern pattern = Pattern.compile(validationSchema);
//		Matcher matcher = pattern.matcher(memberEMail);
//		boolean matchFound = matcher.matches();
//	      if (matchFound==true){
//	        return true;
//	      }
//	      else{
//	        return false;
//	      }		
//	}	
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param password:String = the chosen password of the new member
	 * @return returns true, if the chosen password of the member has minimum a size of 8 chars and includes minimum 2 numbers. it returns false if the password do not match with the mentioned criterias. 
	 */
	public static boolean ValidatePassword(String password){
		char[] passwordList = password.toCharArray();
		int count = 0;
		if(password.length()>7)
		{
			for(int i=0; i<passwordList.length;i++){
				if(passwordList[i]=='1'||passwordList[i]=='2'||passwordList[i]=='3'||passwordList[i]=='4'||passwordList[i]=='5'||passwordList[i]=='6'||passwordList[i]=='7'||passwordList[i]=='8'||passwordList[i]=='9'){
				count++;
					if(count ==2){
						return true;
					}
				}
			}
		}
		return false; 			  		
	}
	/*
	public static void postMail( String recipient,String subject,String message, String from )throws MessagingException{     
		
		Properties props = new Properties();     
		props.put( "mail.smtp.host", "mail.mailserver.com" );     
		Session session = Session.getDefaultInstance( props );     
		Message msg = new MimeMessage( session );     
		InternetAddress addressFrom = new InternetAddress( from );     
		msg.setFrom( addressFrom );     
		InternetAddress addressTo = new InternetAddress( recipient );     
		msg.setRecipient( Message.RecipientType.TO, addressTo );     
		msg.setSubject( subject );     
		msg.setContent( message, "text/plain" );     
		Transport.send( msg );   
	} */		
}

