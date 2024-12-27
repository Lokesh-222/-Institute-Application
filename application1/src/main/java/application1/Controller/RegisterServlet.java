package application1.Controller;

import java.io.IOException;

import application1.DAO.RegisterInsert;
import application1.Model.RegisterModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlet Lokesh");
		String id=request.getParameter("id");
		String name=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String phno=request.getParameter("mobileno");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cid =request.getParameter("cid");

		System.out.println(name);
		RegisterModel rm=new RegisterModel();
	//	rm.setId(id);
		rm.setFirstname(name);
		rm.setLaststname(lname);
		rm.setPhoneno(phno);
		rm.setEmail(email);
		rm.setPassword(password);
		rm.setCid(cid);

		RegisterInsert ri=new RegisterInsert();
		String status=ri.insertName(rm);
		if(status.equals("Success")) {
	        request.setAttribute("registeredId", rm.getId());
		RequestDispatcher rd=request.getRequestDispatcher("/StudentRegister.jsp");
		rd.include(request, response);
		}
		else {
		RequestDispatcher rd1=request.getRequestDispatcher("/Registration.html");
		rd1.include(request, response);
		}
	}

}
