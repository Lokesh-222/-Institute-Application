package application1.Model;

public class RegisterModel {
	private int id;
	private String firstname;
	private String laststname;
	private String phoneno;
	private String email;
	private String password;
	private String cid;

	public RegisterModel() {

	}

	public RegisterModel(int id, String firstname, String laststname, String phoneno, String email, String password,
			String cid) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.laststname = laststname;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
		this.cid = cid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLaststname() {
		return laststname;
	}
	public void setLaststname(String laststname) {
		this.laststname = laststname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}



	}

