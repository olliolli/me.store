package Servlets;

import java.io.IOException;

import javax.naming.ServiceUnavailableException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberManagement.Member;
import MemberManagement.MemberRegistration;
import MemberManagement.PasswordService;
import MemberManagement.Role;

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
		String passwordHash = request.getParameter("password");
		// Das eingegebene Passwort validieren ( min 8 Zeichen inkl. min 2 Zahlen)
		boolean passwordCheck = MemberRegistration.ValidatePassword(passwordHash);
		Role memberRole = Role.Member;
	
		if(passwordCheck==true){
			try {
				//Das eingegebene Passwort wird in einen Hashwert überführt
				passwordHash = PasswordService.getInstance().Encrypt(request.getParameter("password"));
				// Alle Parameter werden an RegistrateUser übergeben und der User wird gepseichert.
				MemberRegistration.RegistrateUser(firstName, lastName, eMail, street, hnr, postCode, city, passwordHash, memberRole);
			} catch (ServiceUnavailableException e) {
				e.printStackTrace();
			}
		}
		else{
			request.setAttribute(passwordHash, "Das Passwort muss 8 Zeichen lang sein und min. 2 Zahlen enthalten");
		}
		
	}

}
