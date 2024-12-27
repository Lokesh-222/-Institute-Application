package application1.Model;

	public class LoginModel {
		private String email;
		private String password;
		private String role;

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
			System.out.println("in model username : "+email);
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
			System.out.println("in model password : "+password);
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return role;
		}

	}



