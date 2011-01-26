package Servlets;

import java.io.IOException;

import javax.naming.ServiceUnavailableException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberManagement.Member;
import MemberManagement.MemberRegistration;
import MemberManagement.PasswordService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eMail = request.getParameter("username");
		String pwdHash = null;
		try {
			//Das eingegebene Passwort wird in einen Hashwert �berf�hrt
			pwdHash = PasswordService.getInstance().Encrypt(request.getParameter("password"));
			// Alle Parameter werden an RegistrateUser �bergeben und der User wird gepseichert.
		} catch (ServiceUnavailableException e) {
			e.printStackTrace();
		}
		
		Member member = MemberManagement.MemberLogin.returnMember(eMail, pwdHash);
		if(member.GetMemberID() >= 1){
			HttpSession session = request.getSession(true);
			session.setAttribute("member", member);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home");
			dispatcher.forward(request, response);
		}
		else{
			HttpSession session = request.getSession(true);
			session.setAttribute("member", member);		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
