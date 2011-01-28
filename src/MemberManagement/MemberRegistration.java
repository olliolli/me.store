package MemberManagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
26.01.2011      SG              Neuer regulärer Ausdruck eingefügt bei EMail Validierung
                                Neue Methode zum überprüfen, ob sich beide eingegebenen Passwörter gleichen
                                
Allgemeine Funktionsbeschreibung:Die Methode erstellt ein Member Objekt 
anhand der vom Controller übergebenen Parameter 
und greift anschließend auf die Methode zum Speichern des neuen Benutzers zu.
--> Dabei werden zunächst die vom Controller übergebenen Daten überprüft.
* */
public class MemberRegistration {
	
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.4
	 * @since 13.01.2011
	 * @param firstName - (STRING) the firstname of the member
	 * @param lastName - (STRING) the lastname of the member
	 * @param eMail - (STRING) the email address of the member
	 * @param street - (STRING) the street as a part of the members address
	 * @param streetNumber - (STRING) the streetnumber as a part of the members address
	 * @param postCode - (STRING) the postcode as a part of the members address
	 * @param city - (STRING) the city as a part of the members address
	 * @param passwordHash - (STRING) the password hash value of the member
	 * @param memberRole - (Enum ROLE) the role of the member
	 * @return result - (INTEGER) a check value which identifies if the registration process was successful (value=0) or if it was not (value=1)
	 
	 */
	public static int RegistrateUser(String firstName,String lastName, String eMail, String street, String streetNumber, String postCode, String city, String passwordHash, Role memberRole){
		//if(firstName.length()<2 || lastName.length()<2 || street.length()<3 || streetNumber.length()==0) {      
		int result = 0;
		try{
			        	Member member = new Member();
			        	member.SetCity(city);
						member.SetEMail(eMail.toUpperCase());
						member.SetFirstName(firstName);
						member.SetLastName(lastName);
						member.SetMemberRole(memberRole);
						member.SetPasswordHash(passwordHash);
						member.SetPostCode(postCode);
						member.SetStreet(street);
						member.SetStreetNumber(streetNumber);				
						DBCommands.InsertMember(member);	
						return result;
			        }
			        catch(Exception e){
			        	return result+1;
			        }
	}
	
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param eMail :String = the eMail address of the member
	 * @return true --> if the member is already registrated, false --> if the member is even not registrated 
	 */
	public static boolean IsAlreadyRegistrated(String eMail){
		String membersEMail = DBCommands.SelectMemberByEMail(eMail.toUpperCase());
        if(membersEMail.equals("")) {
        		return false;
    	}
        else if(membersEMail.toUpperCase().equals(eMail.toUpperCase())){
			return true;
		}
		else{
			return false;
		}		
	}
	
	/**
	 * @author: Grunewald Stephanie
	 * @version: 1.1
	 * @param memberEMail :String = the eMail address of the member
	 * @return true --> if the eMail address has the correct format, false --> if the eMail address do not have the correct format
	 */
	public static boolean ValidateMemberEMail(String memberEMail){
		String validationSchema = "^([a-zA-Z0-9\\-\\.\\_]+)(\\@)([a-zA-Z0-9\\-\\.]+)(\\.)([a-zA-Z]{2,4})$";
		Pattern pattern = Pattern.compile(validationSchema);
		Matcher matcher = pattern.matcher(memberEMail);
		boolean matchFound = matcher.matches();
	      if (matchFound==true){
	        return true;
	      }
	      else{
	        return false;
	      }		
	}	
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
				if(passwordList[i]=='0'|| passwordList[i]=='1'||passwordList[i]=='2'||passwordList[i]=='3'||passwordList[i]=='4'||passwordList[i]=='5'||passwordList[i]=='6'||passwordList[i]=='7'||passwordList[i]=='8'||passwordList[i]=='9'){
				count++;
					if(count >=2){
						return true;
					}
				}				
			}
			if (count<2){
				return false;
			}
		}
		return false; 			  		
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param w_password - the repeated password
	 * @param password - the origin passwort
	 * @return true - if the both passwords are equal, false - if they are not eqaul
	 */
	public static boolean CheckPasswordsEquity(String w_password, String password){
		if(w_password.equals(password)){
			return true;
		}
		else{
			return false;
		}
		
	}
}

