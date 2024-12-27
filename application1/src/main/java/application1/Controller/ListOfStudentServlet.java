package application1.Controller;

import java.io.IOException;
import java.util.List;

import application1.DAO.RegisterInsert;
import application1.Model.StudentListModel;
import application1.Model.StudentListModelData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfStudentServlet
 */
@WebServlet("/ListServlet")
public class ListOfStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Table_name="Student";
		System.out.println(Table_name);
		StudentListModel lm=new StudentListModel();
		lm.setTable_name(Table_name);
		RegisterInsert rs=new RegisterInsert();
		List<StudentListModelData> listStudent = rs.selectAllStudents(lm);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);

	}

}
