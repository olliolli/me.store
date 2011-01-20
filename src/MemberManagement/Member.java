package MemberManagement;
/*
Anlagedatum: 10.01.2011
Angelegt von: Grunewald, Stephanie

ÄNDERUNGSHISTORIE
Änderungsdatum | Geändert von | Änderungsbeschreibung                | Versionsnummer
--------------------------------------------------------------------------------------
10.01.2011      SG              substitute address with                1.1
                                street, streetNumber, postCode, cuty

Allgemeine Funktionsbeschreibung:Beschreibung des Objektes "Member"

* */ 
public class Member {
	private Role memberRole;
	private String firstName;
	private String lastName;
	private String eMail;
	private String street;
	private String streetNumber;
	private String postCode;
	private String city;
	private int memberID;
	private String password;
	
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param memberID :int = the identificationnumber of the member which it has been created by the database
	 * @param memberRole :enum = role of the member (member or admin)
	 * @param firstName :String = the firstName of the member
	 * @param lastName :String = the lastname of the member
	 * @param eMail :String = the eMail address of the member
	 * @param street :String = the street of the member
	 * @param streetNumber :String = the number of the street the member lives
	 * @param postCode :String = the postcode of the city of the member
	 * @param city :String = the city of the member
	 * @param password :String = the login password of the member
	 * @return no return because it is a construktor for instantiating a member object when the member already exists
	 */
	public Member(int memberID,Role memberRole, String firstName, String lastName,
			String eMail, String street, String streetNumber, String postCode,
			String city,String password) {
		this.SetMemberRole(memberRole);
		this.SetFirstName(firstName);
		this.SetLastName(lastName);
		this.SetEMail(eMail);
		this.SetStreet(street);
		this.SetStreetNumber(streetNumber);
		this.SetPostCode(postCode);
		this.SetCity(city);
		this.memberID = memberID;
		this.SetPassword(password);
	}
	/** 
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @param memberID:Integer, set the memberID of the Member
	 */
	public void SetMemberID(int memberID){
		this.memberID = memberID;
	}
	/**
	 * @param city :String = the city of the member
	 * @param password :String = the login password of the member
	 * @return no return because it is a construktor for instantiating a member object when the member even do not exists
	 */
	public Member(Role memberRole, String firstName, String lastName,
			String eMail, String street, String streetNumber, String postCode,
			String city,String password) {
		this.SetMemberRole(memberRole);
		this.SetFirstName(firstName);
		this.SetLastName(lastName);
		this.SetEMail(eMail);
		this.SetStreet(street);
		this.SetStreetNumber(streetNumber);
		this.SetPostCode(postCode);
		this.SetCity(city);		
		this.SetPassword(password);
	}
	/**
	 * @return no return because it is the standard construktor
	 */
	public Member() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return the streetNumber of the members address:String
	 */
	public String GetStreetNumber() {
		return streetNumber;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @param the streetNumber:String of the members address:String
	 */
	public void SetStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return the postCode of the members address:String
	 */
	public String GetPostCode() {
		return postCode;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @param the postCode:String of the members address
	 */
	public void SetPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return the city of the members address:String
	 */
	public String GetCity() {
		return city;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @param the city:String of the members address
	 */
	public void SetCity(String city) {
		this.city = city;
	}
	
	
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the memberRole of the member:enum
	 */
	public Role GetMemberRole() {
		return memberRole;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param memberRole:enum, set the memberRole of the Member
	 */
	public void SetMemberRole(Role memberRole) {
		this.memberRole = memberRole;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return the foreName of the member:String
	 */
	public String GetFirstName() {
		return firstName;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.1
	 * @param foreName:String, set the foreName of the Member
	 */
	public void SetFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the lastName of the member:String
	 */
	public String GetLastName() {
		return lastName;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param lastName:String, set the lastName of the Member
	 */
	public void SetLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the eMail of the member:String
	 */
	public String GetEMail() {
		return eMail;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param eMail:String, set the eMail of the Member
	 */
	public void SetEMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the address of the member:String
	 */
	public String GetStreet() {
		return street;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.1
	 * @param address:String, set the address of the Member
	 */
	public void SetStreet(String street) {
		this.street = street;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the memberID of the member:integer
	 */
	public int GetMemberID() {
		return memberID;
	}
		
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return the password of the member:String
	 */
	public String GetPassword() {
		return password;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param password:String, set the foreName of the Member
	 */
	public void SetPassword(String password) {
		this.password = password;
	}	

}
