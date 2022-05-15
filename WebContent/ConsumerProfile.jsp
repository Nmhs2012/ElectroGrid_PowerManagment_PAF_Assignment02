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
	 
	 			<h1 class="m-3">Consumer</h1>
	 
				 <form id="formProfile" name="formProfile" class="justify-content-center" style="width: 60%">
				 
				 <!-- NAME -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblName">Name: </span>
					 </div>
					 <input class="form-control" type="text" id="name" name="name">
				 </div>
				 
				 <!-- ADDRESS -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblAddress">Address: </span>
					 </div>
					 <input class="form-control" type="text" id="address" name="address">
				 </div>
				 
				 <!-- MOBILE -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblMobile">Mobile: </span>
					 </div>
					 <input class="form-control" type="text" id="mobile" name="mobile">
				 </div>
				 
				 <!-- NIC -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblEmail">NIC: </span>
					 </div>
					 <input class="form-control" type="text" id="nic" name="nic">
				 </div>
				 
				 <!-- EMAIL -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblEmail">Email: </span>
					 </div>
					 <input class="form-control" type="text" id="email" name="email">
				 </div>
				 
				 <!-- USERNAME -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblUsername">User Name: </span>
					 </div>
					 <input class="form-control" type="text" id="username" name="username">
				 </div>
				 
				 <!-- PASSWORD -->
				 <div class="form-row">
					 <div class="form-group col-md-6">
					 	<span class="form-label" id="lblPassword">Password: </span>
					 </div>
					 <input class="form-control" type="text" id="password" name="password">
				 </div>
				 
				<input class = "btn btn-primary mr-3" type="button" id="btnSave" value="Save" class="btn btn-primary">
				<input type="hidden" id="hidProfileIDSave" name="hidProfileIDSave" value="">
				
				</form>
				
				<br>
				<div class="ml-5">
			<h2 class="mb-3">Consumer Details</h2>
		</div>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
	 	<div id="divConsumerGrid" class="col-12 mb-5 table table-responsive container-fluid table-striped row justify-content-center">
	 	<%
 			out.print(ConsumerDBUtill.viewConsumer()); 
 		%>
		</div>
		
			</div>
		</div>
	</div>
</body>
</html>