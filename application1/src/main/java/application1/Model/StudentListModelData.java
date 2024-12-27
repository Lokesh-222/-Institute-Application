package application1.Model;

public class StudentListModelData {
	int id;
	String firstname;
	String lastname;
	String phoneno;
	String email;
	String password ;
	int cid;

	public StudentListModelData() {

	}

	public StudentListModelData(int id, String firstname, String lastname,String phoneno, String email, String password ,int cid) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phoneno=phoneno;
		this.email=email;
		this.password=password;
		this.cid=cid;
	}




}
