package Servlets;
import java.io.IOException;
import javax.naming.ServiceUnavailableException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import MemberManagement.*;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// eingegebene Parameter in Registrierungsformular holen und Variablen belegen
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String eMail = request.getParameter("email");
		String city = request.getParameter("r_place");
		String postCode = request.getParameter("r_zip");
		String street = request.getParameter("r_street");
		String hnr = request.getParameter("r_hnr");
		String password = request.getParameter("password");
		if(MemberRegistration.ValidatePassword(password)==true)
		{
			if(MemberRegistration.CheckPasswordsEquity(request.getParameter("w_password"),password)==true){
				if(MemberRegistration.ValidateMemberEMail(eMail)==true){
					//if(MemberRegistration.IsAlwaysRegistrated(eMail)==false){
						try {
							String passwordHash = PasswordService.getInstance().Encrypt(password);
							int result = MemberRegistration.RegistrateUser(firstName, lastName, eMail, street, hnr, postCode, city, passwordHash, Role.Member);						
							if(result == 2){
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
								dispatcher.forward(request, response);
								JOptionPane.showMessageDialog(null, "Sie haben nicht alle Felder ausgefüllt. Bitte überprüfen Sie Ihre Eingaben", "Fehlende Daten", JOptionPane.OK_CANCEL_OPTION);
							}
							else{
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
								dispatcher.forward(request, response);
								JOptionPane.showMessageDialog(null, "Ihre Registrierung bei me.store war erfolgreich!\n Sie können sich nun mit Ihren Benutzerdaten einloggen.", "Herzlichen Glückwunsch", JOptionPane.OK_CANCEL_OPTION);
							}
						} 
						catch (ServiceUnavailableException e1) {
							e1.printStackTrace();
							e1.getExplanation();
							e1.getMessage();
							e1.getLocalizedMessage();
						}
//					}
//					else{
//						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
//						dispatcher.forward(request, response);
//						JOptionPane.showMessageDialog(null, "Sie sind bereits mit der eingegebenen EMail bei uns registriert.\n Wenn Sie ihr Passwort vergessen haben können Sie dieses über den Loginbereich anfordern.", "Systemmeldung", JOptionPane.OK_CANCEL_OPTION);
//					}
				}
				else{
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
					dispatcher.forward(request, response);
					JOptionPane.showMessageDialog(null, "Die eingegebene EMail hat ein falsches Format. \n Bitte überprüfen Sie Ihre Eingabe.", "Falsche Eingabe", JOptionPane.OK_CANCEL_OPTION);
				}				
			}
			else{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
				dispatcher.forward(request, response);
				JOptionPane.showMessageDialog(null, "Das eingebene Passwort und das wiederholte Passwort stimmen nicht überein!\n Bitte wiederholen Sie die Eingaben erneut.", "Falsche Eingabe", JOptionPane.OK_CANCEL_OPTION);
			}			
		}
		else{			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);
			JOptionPane.showMessageDialog(null, "Das eingegebene Passwort ist falsch! \n Es muss aus mindestens 8 Buchstaben inklusive 2 Zahlen bestehen.", "Falsche Eingabe", JOptionPane.OK_CANCEL_OPTION);
		}
				
	}

}
