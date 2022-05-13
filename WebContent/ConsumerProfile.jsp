<%@ page import="utill.ConsumerDBUtill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Consumer Profile</title>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.6.0.min.js"></script>
	<script src="Components/Profile.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-8">
	 
	 			<h1 class="m-3">PROFILE</h1>
	 
				 <form id="formProfile" name="formProfile">
				 
				 <!-- NAME -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblName">Name: </span>
					 </div>
					 <input type="text" id="name" name="name">
					 <p style = "color:Red">*</p>
				 </div>
				 
				 <!-- ADDRESS -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblAddress">Address: </span>
					 </div>
					 <input type="text" id="address" name="address">
				 </div>
				 
				 <!-- MOBILE -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblMobile">Mobile: </span>
					 </div>
					 <input type="text" id="mobile" name="mobile">
				 </div>
				 
				 <!-- NIC -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblEmail">NIC: </span>
					 </div>
					 <input type="text" id="nic" name="nic">
				 </div>
				 
				 <!-- EMAIL -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblEmail">Email: </span>
					 </div>
					 <input type="text" id="email" name="email">
				 </div>
				 
				 <!-- USERNAME -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblUsername">User Name: </span>
					 </div>
					 <input type="text" id="username" name="username">
				 </div>
				 
				 <!-- PASSWORD -->
				 <div class="input-group input-group-sm mb-3">
					 <div class="input-group-prepend">
					 	<span class="input-group-text" id="lblPassword">Password: </span>
					 </div>
					 <input type="text" id="password" name="password">
				 </div>
				 
				 <div id="alertSuccess" class="alert alert-success"></div>
				 <div id="alertError" class="alert alert-danger"></div>
				 
				<input type="button" id="btnSave" value="Save" class="btn btn-primary">
				<input type="hidden" id="hidProfileIDSave" name="hidProfileIDSave" value="">
				
				</form>
			</div>
		</div>
	 
		<br>
	 	<div id="divItemsGrid">
	 	<%
	 		ConsumerDBUtill consumerObj = new ConsumerDBUtill(); 
 			out.print(consumerObj.viewConsumer()); 
 		%>
	</div>
		
	</div>
</body>
</html>