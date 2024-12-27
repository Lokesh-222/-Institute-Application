package application1.Controller;

import java.io.IOException;

import application1.DAO.RegisterInsert;
import application1.Model.FacultyRegisterModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FacultyRegisterServlet
 */
@WebServlet("/FacultyRegister")
public class FacultyRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String id=request.getParameter("id");
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String phno=request.getParameter("mobileno");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cid =request.getParameter("cid");

		System.out.println(fname);
		FacultyRegisterModel frs=new FacultyRegisterModel();
		frs.setFfname(fname);
		frs.setFlname(lname);
		frs.setPhno(phno);
		frs.setEmail(email);
		frs.setPassword(password);
		frs.setCid(cid);
		RegisterInsert ri=new RegisterInsert();
		String status=ri.Facultyinsert(frs);
		if(status.equals("Success")) {
	        request.setAttribute("registeredId", frs.getId());
			RequestDispatcher rd=request.getRequestDispatcher("/FacultyRegister.jsp");
			rd.include(request, response);
			}
			else {
			RequestDispatcher rd1=request.getRequestDispatcher("/FacultyRegistration.html");
			rd1.include(request, response);
			}

	}

}
