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
		if(MemberRegistration.ValidatePassword(password)==true){
			if(MemberRegistration.CheckPasswordsEquity(request.getParameter("w_password"),password)==true){
				if(MemberRegistration.ValidateMemberEMail(eMail)==true){
					if(MemberRegistration.IsAlreadyRegistrated(eMail)==false){
						try {
							String passwordHash = PasswordService.getInstance().Encrypt(password);
							int result = MemberRegistration.RegistrateUser(firstName, lastName, eMail, street, hnr, postCode, city, passwordHash, Role.Member);						
							if(result==1){
								request.setAttribute("error", "Bei der Registrierung ist ein Fehler aufgetreten. BItte versuchen Sie es zu einem späteren Zeitpunkt erneut. Vielen Dank!");
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
								dispatcher.forward(request, response);
								
							}
							else{
								request.setAttribute("error", "Ihre Registrierung war erfolgreich. Bitte loggen Sie sich nun mit Ihren Daten ein.");
								RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
								dispatcher.forward(request, response);								
							}
						} 
						catch (ServiceUnavailableException e1) {
							e1.printStackTrace();
							e1.getExplanation();
							e1.getMessage();
							e1.getLocalizedMessage();
						}
					}
					else{
						request.setAttribute("error", "Sie sind mit der angegebenen EMail bereits bei uns registriert. Bitte geben Sie eine andere E-Mail an oder fordern Sie ein neues Passwort an.");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
						dispatcher.forward(request, response);
						
					}
				}
				else{
					request.setAttribute("error", "Die eingebebene EMail Adresse hat ein falsches Format. Bitte korrigieren Sie Ihre Eingaben!");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
					dispatcher.forward(request, response);
					
				}				
			}
			else{
				request.setAttribute("error", "Das eingegebene und das wiederholte Passwort sind nicht identisch. Bitte geben Sie Ihre Daten erneut ein.");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
				dispatcher.forward(request, response);				
			}			
		}
		else{
			request.setAttribute("error", "Bitte geben Sie ein anderes Passwort ein, dass aus mindestens 8 Zeichen inklusive 2 Zahlen besteht.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);			
		}
				
	}

}
