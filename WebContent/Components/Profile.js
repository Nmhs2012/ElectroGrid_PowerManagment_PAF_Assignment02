$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateCustomerForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidProfileIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
			{ 
				url : "ConsumerAPI", 
				type : type, 
				data : $("#formProfile").serialize(), 
				dataType : "text", 
				complete : function(response, status) 
				{ 
					if(type == "POST"){
						onConsumerSaveComplete(response.responseText, status); 
					}
					
					else{
						onConsumerUpdateComplete(response.responseText, status); 
					}
					
				} 
			});
	
});

function onConsumerSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			
			$("#alertSuccess").text("Inserted Successfully");
			$("#alertSuccess").show();
			$("#divConsumerGrid").html(resultSet.data);
			
								
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidProfileIDSave").val("");
}


function validateCustomerForm()
{
	//Name
	if ($("#name").val().trim() == "")
	{
		return "Insert Name.";
	}
	//Address
	if ($("#address").val().trim() == "")
	{
		return "Insert Address.";
	} 

	//Mobile
	if ($("#mobile").val().trim() == "")
	{
		return "Insert Mobile.";
	}
	
	//NIC 
	if ($("#nic").val().trim() == "")
	{
		return "Insert NIC.";
	}
	
	//Email
	if ($("#email").val().trim() == "")
	{
		return "Insert Email.";
	}
	//User name
	if ($("#username").val().trim() == "")
	{
		return "Insert User Name.";
	} 

	//Password
	if ($("#password").val().trim() == "")
	{
		return "Insert Password.";
	}	
	
	return true;
}

$(document).on("click", ".btnRemove", function(event) 
{ 
	$.ajax( 
	{ 
		url : "ConsumerAPI", 
		type : "DELETE", 
		data : "conId=" + $(this).data("conid"),
		dataType : "text", 
		complete : function(response, status) 
		{ 
			onConsumerDeleteComplete(response.responseText, status); 
		} 
	}); 
});

function onConsumerDeleteComplete(response, status) 
{ 
	if (status == "success") 
	{ 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
		 { 
			 $("#alertSuccess").text("Successfully deleted."); 
			 $("#alertSuccess").show(); 
			 $("#divConsumerGrid").html(resultSet.data); 
		 } else if (resultSet.status.trim() == "error") 
		 { 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
		 } 
	} else if (status == "error") 
	{ 
		$("#alertError").text("Error while deleting."); 
		$("#alertError").show(); 
	} else
	{ 
		 $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 
	} 
}

$(document).on("click", ".btnUpdate", function(event) 
{ 
	$("#hidProfileIDSave").val($(this).data("conid")); 
	$("#name").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#address").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#mobile").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("#email").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#nic").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#username").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#password").val($(this).closest("tr").find('td:eq(6)').text());
});

function onConsumerUpdateComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Updated Sucessfully...");
			$("#alertSuccess").show();
			$("#divConsumerGrid").html(resultSet.data);
						
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while updating.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while updating..");
		$("#alertError").show();
	}
	$("#hidProfileIDSave").val("");
}
