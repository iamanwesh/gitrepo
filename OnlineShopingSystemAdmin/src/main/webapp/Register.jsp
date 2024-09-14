<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
@import "font-awesome.min.css";
@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
  padding-top: 20px;
  padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}

/* Custom page header */
.header {
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}

/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media (min-width: 768px) {
  .container {
    max-width: 730px;
  }
}
.container-narrow > hr {
  margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p + h4 {
  margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header,
  .marketing,
  .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
</style>
</head>
<body>
<div class="container">
    <h1 class="well">Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form action="register" method="post">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Email</label>
								<input type="email" placeholder="Enter Email Here.." name="email" class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Password</label>
								<input type="password" placeholder="Enter password Here.." name="password" class="form-control">
							</div>
						</div>		
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Name</label>
								<input type="text" placeholder="Enter Name Here.." name="name" class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label>Gender</label><br/>
								<input type="radio" name="gender" value="male"> Male &nbsp;
								<input type="radio" name="gender" value="female"> Female
							</div>
						</div>		
							<div class="form-group">
						<label>Phone Number</label>
						<input type="text" placeholder="Enter Phone Number Here.." name="phone" class="form-control">
					</div>				
						<div class="form-group">
							<label>Full Address</label>
							<textarea placeholder="Enter Address Here.." name="address" rows="3" class="form-control"></textarea>
						</div>	
						
					<button type="submit" value="submit" class="btn btn-lg btn-info">Submit</button>	
								<a href="login.jsp" > Already Have Login here...</a>	
					</div>
				</form> 
				</div>
	</div>
	</div>
	<%
String ms=(String)request.getAttribute("msg");
out.println(ms);
%>
</body>
</html>