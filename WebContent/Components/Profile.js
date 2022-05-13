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
					onConsumerSaveComplete(response.responseText, status); 
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
			$("#alertSuccess").text("Successfully saved."); 
			$("#alertSuccess").show(); 
			$("#divItemsGrid").html(resultSet.data); 
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
	$("#formProfile")[0].reset(); 
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

