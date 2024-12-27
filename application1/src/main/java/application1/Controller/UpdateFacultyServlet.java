package application1.Controller;

import java.io.IOException;

import application1.DAO.RegisterInsert;
import application1.Model.UpdateFacultyModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateFacultyServlet
 */
@WebServlet("/updateFaculty")
public class UpdateFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateFaculty");
		int id=Integer.parseInt(request.getParameter("fid"));
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String phno=request.getParameter("mobileno");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cid =request.getParameter("cid");

		UpdateFacultyModel ufm=new UpdateFacultyModel();
		ufm.setId(id);
		ufm.setFirstname(fname);
		ufm.setLastname(lname);
		ufm.setMobileno(phno);
		ufm.setEmail(email);
		ufm.setPassword(password);
		ufm.setCid(cid);
		RegisterInsert ri=new RegisterInsert();
		String status=ri.facultyUpdate(ufm);
		if(status.equals("Success")) {
			request.setAttribute("fid", ufm.getId());
			RequestDispatcher rd=request.getRequestDispatcher("/FacultyUpdate.jsp");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/UpdateFaculty.html");
			rd.include(request, response);
		}



	}

}
