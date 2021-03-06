package utill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Consumer;

public class ConsumerDBUtill {

		//Create objects for database Connection class
		private static Connection con = null;
		private static Statement stat = null;
		private static ResultSet rs = null;
		
		//View Consumer Details
		public static String viewConsumer(){
			
			String output = "";
			
			try {
				
				con = DBConnect.getConnection();
				stat = con.createStatement();
				
				// Prepare the html table to be displayed
				output = "<table border='1'><tr></th><th>Name</th><th>Address</th>" 
						+ "<th>Mobile</th><th>Email</th><th>NIC</th><th>Username</th><th>Password</th><th>Update</th><th>Remove</th></tr>";
				
				//SQL Query			
				String sql = "select * from consumer";
							
				rs= stat.executeQuery(sql);
				
				while(rs.next()) {
					String conId = rs.getString(1);
					String name = rs.getString(2);
					String address = rs.getString(3);
					String mobile = rs.getString(4);				
					String email = rs.getString(5);
					String nic = rs.getString(6);
					String username = rs.getString(7);
					String password = rs.getString(8);
				
					// Add into the html table
					output += "<tbody style='padding:10px; text-align:center;'><td ><input id='hidConIDUpdate' name='hidConIDUpdate' type='hidden' value='" + conId + "'>" + name + "</td>";
					//output += "<td>" + name + "</td>";
					output += "<td>" + address + "</td>";
					output += "<td>" + mobile + "</td>";		
					output += "<td>" + email + "</td>";	
					output += "<td>" + nic + "</td>";	
					output += "<td>" + username + "</td>";
					output += "<td>" + password + "</td>";	
					 
					 // buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-conid='" + conId + "'></td>" + 
							"<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-conid='" + conId + "'>" + "</td></tbody>"; 
				}
				
				// Complete the html table
				 output += "</table>";
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return output;
		}
		
		//Read Consumer Profile Data
			public static List<Consumer> viewProfile(String userName){
				
				ArrayList<Consumer> consumer = new ArrayList<>();
				
				try {
					
					con = DBConnect.getConnection();
					stat = con.createStatement();
					
					//SQL Query			
					String sql = "select * from consumer where username = '"+userName+"'";
								
					rs= stat.executeQuery(sql);
					
					while(rs.next()) {
						String conId = rs.getString(1);
						String name = rs.getString(2);
						String address = rs.getString(3);
						String mobile = rs.getString(4);				
						String email = rs.getString(5);
						String nic = rs.getString(6);
						String username = rs.getString(7);
						String password = rs.getString(8);
					
						//Create Consumer Object
						Consumer c = new Consumer(conId, name, address, nic, mobile, email, username, password);
						consumer.add(c);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				return consumer;
			}
		
			//Insert Consumer Profile Details
			public static String insertProfileDetails(String name, String address, String mobile, String nic, String email, String username, String  password) {
			    
		    	String output = "";
		    	
		    	try {
		    		con = DBConnect.getConnection();
		    		stat = con.createStatement();
		    	    String sql = "insert into consumer values (0, '"+name+"', '"+address+"', '"+mobile+"', '"+email+"', '"+nic+"','"+username+"', '"+password+"')";
		    		int rs = stat.executeUpdate(sql);
		    		if(rs > 0) {
		    			String newConsumerDetails = viewConsumer(); 
		    			
		    			output = "{\"status\":\"success\", \"data\": \"" + newConsumerDetails + "\"}";
		    		}
		    		else {
		    			output = "{\"status\":\"error\", \"data\": \"Error while saving the details.\"}"; 
		    		}
		    	}
		    	catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    	return output;
		    }
			
			//Update Consumer Profile Details
			public static String updateProfileDetails(String conId, String name, String address, String mobile, String nic, String email, String username, String  password) {
				
				String output = "";
				System.out.println("consumerId:" + conId);
		    	try {
		    		con = DBConnect.getConnection();
		    		stat = con.createStatement();
		    		String sql = "update consumer set name='"+name+"',address='"+address+"',mobile='"+mobile+"',nic='"+nic+"',email='"+email+"',username='"+username+"', password='"+password+"'"+ "where conId='"+conId+"'";
		    		int rs = stat.executeUpdate(sql);
		    		
		    		if(rs > 0) {
		    			String newConsumerDetails = viewConsumer(); 
		    			
		    			output = "{\"status\":\"success\", \"data\": \"" + newConsumerDetails + "\"}";
		    		}
		    		else {
		    			output = "{\"status\":\"error\", \"data\": \"Error while updating the details.\"}"; 
		    		}
		    		
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    	return output;
		    }
			
			//Delete Profile
			public static String deleteProfileDetails(String conId) {
				
				String output = ""; 
				int convertID = Integer.parseInt(conId);
				
				//Validate
				try {		
					con = DBConnect.getConnection();
					stat = con.createStatement();
							
					//SQL Query			
					String sql = "delete from consumer where conId ='"+convertID+"'";
							
							//Run SQL Query
							int a = stat.executeUpdate(sql); 
							
							if(a > 0) {
								String newConsumerDetails = viewConsumer(); 
								 output = "{\"status\":\"success\", \"data\": \"" + newConsumerDetails + "\"}"; 

							}
							else {
								output = "{\"status\":\"error\", \"data\": \"Error while deleting the details.\"}";
							}
						}catch(Exception e) {
							e.printStackTrace();
						}
				
				return output;
			}
	
	
}
