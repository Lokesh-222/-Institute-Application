package application1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.model.CourseAddModel;
//import com.model.RemoveStudentModel;
//import com.model.StudentModel;

import application1.Model.FacultyRegisterModel;
import application1.Model.LoginModel;
import application1.Model.RegisterModel;
import application1.Model.StudentListModel;
import application1.Model.StudentListModelData;
import application1.Model.UpdateFacultyModel;
import application1.Model.UpdateStudentModel;

public class RegisterInsert {

	public String insertName(RegisterModel r) {
		String status="Fail";
	    int generatedId = -1;  // To store the generated ID

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
			 PreparedStatement ps=con.prepareStatement("insert into student1(sf_name,sl_name,phone_no,email,password,cid) values(?,?,?,?,?,?)",
					 java.sql.Statement.RETURN_GENERATED_KEYS);
//			 RegisterModel rm=new RegisterModel();
			// ps.setString(1, r.getId());
			 ps.setString(1,r.getFirstname());
			 ps.setString(2, r.getLaststname());
			 ps.setString(3,r.getPhoneno());
			 ps.setString(4,r.getEmail());
			 ps.setString(5,r.getPassword());
			 ps.setString(6,r.getCid());

			 System.out.println("inserted");
			 int n=ps.executeUpdate();
			 if(n>0) {
				status="Success";
			}
			 ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                generatedId = rs.getInt(1);  // Get the generated ID
	                r.setId(generatedId);  // Set the ID in the model
	            }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"Hello lokesh Its an Error");
		}


		return status;


	}


	//update student

	public String updateStudent(UpdateStudentModel us) {
		String status="Fail";
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
			 PreparedStatement ps=con.prepareStatement("UPDATE student1 SET sf_name = ?, sl_name = ?, phone_no = ?, email =? , password = ?, cid = ? WHERE sid = ?"
			 		+ "");
//			 RegisterModel rm=new RegisterModel();
			// ps.setString(1, r.getId());
			 ps.setString(1,us.getFirstname());
			 ps.setString(2, us.getLaststname());
			 ps.setString(3,us.getPhoneno());
			 ps.setString(4,us.getEmail());
			 ps.setString(5,us.getPassword());
			 ps.setString(6,us.getCid());
			 ps.setInt(7, us.getId());

//			 System.out.println("updated");
			 int n=ps.executeUpdate();
			 if(n>0) {
				 status="Success";
				 System.out.println("updated"+n);
			 } else {
				System.out.println("no rows updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"Hello lokesh Its an Error");
		}


		return status;


	}


	 // Method to fetch all students from the database
    public List<RegisterModel> getAllStudents() {
        List<RegisterModel> students = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube", "root", "root");

            String query = "SELECT* FROM student1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Iterate through the result set
            while (rs.next()) {
                RegisterModel student = new RegisterModel();
                student.setId(rs.getInt("sid"));
                student.setFirstname(rs.getString("sf_name"));
                student.setLaststname(rs.getString("sl_name"));
                student.setPhoneno(rs.getString("phone_no"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setCid(rs.getString("cid"));

                // Add each student to the list
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;  // Return the list of students
    }



	//Login Dao.

	public String loginSelect(LoginModel l) {
		String role=l.getRole();
		System.out.println(l.getRole());
		String status="Fail";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
			if(role.equals("admin")) {
				PreparedStatement ps=con.prepareStatement("select*from admin where F_name=? and password=?");
				ps.setString(1, l.getEmail());
				ps.setString(2,l.getPassword() );
				System.out.println(l.getEmail());
				System.out.println(l.getPassword());
				System.out.println(l.getRole());
				ResultSet b=ps.executeQuery();
				while(b.next()) {
					status="Success";

				System.out.println("verified succesfully");
				}
			//System.out.println("rs result"+rs.getString("F_name")+"   "+rs.getString("password"));
//				if(rs.getString("F_name").equals(l.getEmail())&&rs.getString("password").equals(l.getPassword())) {
//					status="Success";
//					System.out.println("verified");
//				}
//				else
//					System.out.println("invalid credincials");
			}
			if(role.equals("student")) {
				PreparedStatement ps=con.prepareStatement("select*from student where email=? and password=?");
				ps.setString(1, l.getEmail());
				ps.setString(2,l.getPassword() );
				ResultSet b=ps.executeQuery();
				while(b.next()) {
					status="Success";

				System.out.println("verified succesfully");
				}
			}
			if(role.equals("faculty")) {
				PreparedStatement ps=con.prepareStatement("select*from faculty where email=? and password=?");
				ps.setString(1, l.getEmail());
				ps.setString(2,l.getPassword() );
				ResultSet b=ps.executeQuery();
				while(b.next()) {
					status="Success";

				System.out.println("verified succesfully");
				}
			}

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return status;

	}

	//Removing student Dao.
//	public String removeStudent(RemoveStudentModel rsm) {
//		String status="fail";
//		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
//		 PreparedStatement ps=con.prepareStatement("delete from student1 where sf_name=? and email=?");
//		 ps.setString(1, rsm.getName());
//		 ps.setString(2, rsm.getEmail());
//		int n= ps.executeUpdate();
//		if(n>0) {
//			System.out.println("Delete executed");
//			status="Success";
//		}
//
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return status;
//	}
	public List<StudentListModelData> selectAllStudents(StudentListModel lm) {
		List<StudentListModelData> students = new ArrayList<>();
		String s=lm.getTable_name();
		System.out.println(s);
		System.out.println("in DAO"+s);
		Connection con=null;
		try {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		if(s.equals("Student")) {
		PreparedStatement preparedStatement = con.prepareStatement("select*from student1");
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
		int id = rs.getInt("sid");
		String firstname = rs.getString("sf_name");
		String lastname = rs.getString("sl_name");
		String phoneno=rs.getString("phone_no");
		String email = rs.getString("email");
		String password = rs.getString("password");
		int cid=rs.getInt("cid");
		students.add(new StudentListModelData(id, firstname, lastname,phoneno, email, password,cid));
		System.out.println(id+ firstname+lastname+phoneno+ email+ password+cid);
		}
		}
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		System.out.println("Executed successflly");
		return students;
		}


	//inserting faculty data.

	public String Facultyinsert(FacultyRegisterModel r) {
		String status="Fail";
		int generatedId=-1;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
			 PreparedStatement ps=con.prepareStatement("insert into Faculty2(ff_name,fl_name,phone_no,email,password,cid) values(?,?,?,?,?,?)"
					 ,java.sql.Statement.RETURN_GENERATED_KEYS);
//			 RegisterModel rm=new RegisterModel();
			// ps.setString(1, r.getId());
			 ps.setString(1,r.getFfname());
			 ps.setString(2, r.getFlname());
			 ps.setString(3,r.getPhno());
			 ps.setString(4,r.getEmail());
			 ps.setString(5,r.getPassword());
			 ps.setString(6,r.getCid() );

			 System.out.println("inserted");
			 int n=ps.executeUpdate();
			 if(n>0) {
				status="Success";
			}
			 ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                generatedId = rs.getInt(1);  // Get the generated ID
	                r.setId(generatedId);  // Set the ID in the model
	            }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"Hello lokesh Its an Error");
		}


		return status;


	}

	//update faculty

	public String facultyUpdate(UpdateFacultyModel uf) {
		String status="Fail";
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
			 PreparedStatement ps=con.prepareStatement("update Faculty2 set ff_name=?,fl_name=?,phone_no=?,email=?,password=?,cid=? where fid=?");
//			 RegisterModel rm=new RegisterModel();
			// ps.setString(1, r.getId());
			 ps.setString(1,uf.getFirstname());
			 ps.setString(2,uf.getLastname());
			 ps.setString(3,uf.getMobileno());
			 ps.setString(4,uf.getEmail());
			 ps.setString(5,uf.getPassword());
			 ps.setString(6,uf.getCid() );
			 ps.setInt(7, uf.getId());

			 int n=ps.executeUpdate();

			 System.out.println("updated : "+n);

			 if(n>0) {
				status="Success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"Hello lokesh Its an Error");
		}


		return status;


	}



	//Adding course to the faculty.
//
//	public String FacultyCourseinsert(CourseAddModel r) {
//		String status="Fail";
//		try {
//			 Class.forName("com.mysql.cj.jdbc.Driver");
//			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/vcube","root","root");
//			 PreparedStatement ps=con.prepareStatement("insert into FacultyCourse1(fid,cid) values(?,?)");
////			 RegisterModel rm=new RegisterModel();
//			// ps.setString(1, r.getId());
//			 ps.setString(1,r.getFid());
//			 ps.setString(2, r.getCid());
//
//
//			 System.out.println("inserted");
//			 int n=ps.executeUpdate();
//			 if(n>0)
//				 status="Success";
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage()+"Hello lokesh Its an Error");
//		}
//
//
//		return status;
//
//
//	}



}

