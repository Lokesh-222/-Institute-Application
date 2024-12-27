package application1.Controller;

import java.io.IOException;
import java.util.List;

import application1.DAO.RegisterInsert;
import application1.Model.RegisterModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VieStudentsServlet
 */
@WebServlet("/ViewStudents")
public class VieStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	RegisterInsert ri=new RegisterInsert();
	List<RegisterModel>studentList=ri.getAllStudents();
	 request.setAttribute("students", studentList);

     // Forward the request to the JSP page for display
     RequestDispatcher rd = request.getRequestDispatcher("/viewStudents.jsp");
     rd.forward(request, response);

	}

}
