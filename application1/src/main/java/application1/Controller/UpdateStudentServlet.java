package application1.Controller;

import java.io.IOException;

import application1.DAO.RegisterInsert;
import application1.Model.UpdateStudentModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Update");
		int id=Integer.parseInt(request.getParameter("sid"));
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String phno=request.getParameter("mobileno");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cid =request.getParameter("cid");

		UpdateStudentModel usm=new UpdateStudentModel();
		usm.setId(id);
		usm.setFirstname(fname);
		usm.setLaststname(lname);
		usm.setPhoneno(phno);
		usm.setEmail(email);
		usm.setPassword(password);
		usm.setCid(cid);
		RegisterInsert ri=new RegisterInsert();
		String status=ri.updateStudent(usm);
		if(status.equals("Success")) {
			request.setAttribute("sid", usm.getId());
			RequestDispatcher rd=request.getRequestDispatcher("/StudentUpdate.jsp");
			rd.include(request, response);
			}
			else {
			RequestDispatcher rd1=request.getRequestDispatcher("/UpdateStudent.html");
			rd1.include(request, response);
			}

	}

}
