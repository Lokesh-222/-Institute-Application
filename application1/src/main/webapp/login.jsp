<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="./webpage.css">
<title>LoginPage</title>
<style>
h1 {
	text-align: center;
}

.LoginPage {
	margin: 0 auto;
	display: flex;
	align-items: center;
	justify-content: center;
}

.paddingbottom {
	padding-bottom: 15px;
}

div h1 {
	text-align: left;
}

.ac {
	padding-left: 20px;
	text-decoration: none;
}
</style>
</head>

<body>
	<!-- <h1>Login Page</h1> -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h1>Login Page</h1>
				<form class="form-group" method="post" name="login" action="login"
					onsubmit="return show()">
					<div class="row paddingbottom">
						<div class="col-md-6">
							<label for="username">Email</label>` <input type="text"
								class="form-control" name="username" id="username"
								placeholder=" Enter Email" >
						</div>
						<div class="col-md-6">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="PASSWORD">
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-6">
							<label for="role">Select your role : </label> <select name="role"
								id="role">
								<option value="admin">Admin</option>
								<option value="faculty">Faculty</option>
								<option value="student">Student</option>

							</select>
						</div>
					</div>
					<div class="row paddingbottom">
						<div class="col-md-6">
							<button type="submit" class="btn btn-success">Submit</button>
							<p id="p1"></p>
						</div>
						<div class="col-md-6"></div>

					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>

	</div>
	<script>
        function show() {
            var name = document.getElementById("username").value;
            var pwd = document.getElementById("password").value;
            if (name == "" || pwd == "") {
                document.getElementById("p1").innerHTML = "*Enter Mandatory Fields";
                document.getElementById("p1").style.color = "red";
                return false;
            }
            else
                return true;

        }
        function ValidateEmail() {
            var mail = document.getElementById("username").value;
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
            if (regex.match(mail)) {
                return true;
            } else {
                alert("You have entered an invalid email address!")
                return false;
            }
        }

    </script>

</body>

</html>