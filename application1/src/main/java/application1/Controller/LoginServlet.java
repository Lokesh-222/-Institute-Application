package application1.Controller;

import java.io.IOException;

import application1.DAO.RegisterInsert;
import application1.Model.LoginModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		LoginModel lm=new LoginModel();
		lm.setEmail(email);
		lm.setPassword(password);
		lm.setRole(role);
		RegisterInsert ri=new RegisterInsert();
		String status=ri.loginSelect(lm);
		if(status.equals("Success")) {
			RequestDispatcher rd=request.getRequestDispatcher("/Adminhome.html");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}


	}

}
