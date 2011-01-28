package MemberManagement;

/*
creation date: 10.01.2011
created by: Grunewald, Stephanie

HISTORY OF MODIFICATION
=============================================================================
modification date  | modified from          | description            | version number
-----------------------------------------------------------------------------

decription of the main function:  description of the objects of "Member".

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
	private String passwordHash;
	
	/**
	 * @auhtor Grunewald, Stephanie
	 * @version 1.0
	 * @since 10.01.2011
	 */
	public Member() {
				
	}
	
	/**
	 * @author Falzer, Marcel
	 * @version 1.0
	 * @since 10.01.2011
	 * @param memberID - (INTEGER) the identifikation number of the member
	 * @param memberRole - (Enum ROLE) the role of the member
	 * @param firstName - (STRING) the firstname of the member
	 * @param lastName - (STRING) the lastname of the member
	 * @param eMail - (STRING) the email address of the member
	 * @param street - (STRING) the street as a part of the members address
	 * @param streetNumber - (STRING) the streetnumber as a part of the members address
	 * @param postCode - (STRING) the postcode as a part of the members address
	 * @param city - (STRING) the city as a part of the members address
	 * @param password - (STRING) the password of the member
	 */
		public Member(int memberID,Role memberRole, String firstName, String lastName,
				String eMail, String street, String streetNumber, String postCode,
				String city,String password) {
			
			this.memberRole = memberRole;
			this.firstName = firstName;
			this.lastName=lastName;
			this.city = city;
			this.eMail=eMail;
			this.passwordHash=password;
			this.postCode=postCode;
			this.streetNumber=streetNumber;
			this.street=street;
			this.memberID=memberID;		
		}	
		/**
		 * @author Grunewald, Stephanie
		 * @version 1.0
		 * @since 10.01.2011	
		 * @param memberRole - (Enum ROLE) the role of the member
		 * @param firstName - (STRING) the firstname of the member
		 * @param lastName - (STRING) the lastname of the member
		 * @param eMail - (STRING) the email address of the member
		 * @param street - (STRING) the street as a part of the members address
		 * @param streetNumber - (STRING) the streetnumber as a part of the members address
		 * @param postCode - (STRING) the postcode as a part of the members address
		 * @param city - (STRING) the city as a part of the members address
		 * @param password - (STRING) the password of the member
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
				this.SetPasswordHash(password);
		}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @since 10.01.2011
	 * @param memberID - (INTEGER) the identification number of the member
	 */
	public void SetMemberID(int memberID){
		this.memberID = memberID;
	}
	
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @since 10.01.2011
     * @return streetNumber - (STRING) the streetnumber as a part of the members address 
	 */
	public String GetStreetNumber() {
		return streetNumber;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param streetNumber - (STRING) the streetnumber as a part of the members address 
	 */
	public void SetStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return postCode - (STRING) the postcode as a part of the members address
	 */
	public String GetPostCode() {
		return postCode;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @since 10.01.2011
	 * @param postCode - (STRING) the postcode as a part of the members address
	 */
	public void SetPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @since 10.01.2011
	 * @return city - (STRING) the city as a part of the members address
	 */
	public String GetCity() {
		return city;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param city - (STRING) the city as a part of the members address
	 */
	public void SetCity(String city) {
		this.city = city;
	}
	
	
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return memberRole - (Enum ROLE) the role of the member
	 */
	public Role GetMemberRole() {
		return memberRole;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param memberRole - (Enum ROLE) the role of the member
	 */
	public void SetMemberRole(Role memberRole) {
		this.memberRole = memberRole;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.1
	 * @return firstName - (STRING) the firstname of the member
	 */
	public String GetFirstName() {
		return firstName;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.1
	 * @param firstName - (STRING) the firstname of the member
	 */
	public void SetFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return lastName - (STRING) the lastname of the member
	 */
	public String GetLastName() {
		return lastName;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param lastName - (STRING) the lastname of the member
	 */
	public void SetLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return eMail - (STRING) the email address of the member
	 */
	public String GetEMail() {
		return eMail;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param eMail - (STRING) the email address of the member
	 */
	public void SetEMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return street - (STRING) the street as a part of the members address
	 */
	public String GetStreet() {
		return street;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.1
	 * @param street - (STRING) the street as a part of the members address
	 */
	public void SetStreet(String street) {
		this.street = street;
	}
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return memberID - (INTEGER) the identifikation number of the member
	 */
	public int GetMemberID() {
		return memberID;
	}
		
	/**
	 * @author Grunewald,Stephanie
	 * @version 1.0
	 * @return passwordHash - (STRING) the password has value of the members password
	 */
	public String GetPasswordHash() {
		return passwordHash;
	}
	/**
	 * @author Grunewald, Stephanie
	 * @version 1.0
	 * @param passwordHash - (STRING) the password hash value of the members password
	 */
	public void SetPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}	
}
