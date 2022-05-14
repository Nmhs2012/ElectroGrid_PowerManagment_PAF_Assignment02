package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Consumer;
import utill.ConsumerDBUtill;

@WebServlet("/ConsumerAPI")
public class ConsumerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String output;
		
		output = ConsumerDBUtill.insertProfileDetails(name, address, mobile, nic, email, username, password);
		
		response.getWriter().write(output); 
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
		 Map<String, String> map = new HashMap<String, String>(); 
		 try
		 { 
			 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
			 String queryString = scanner.hasNext() ? 
			 scanner.useDelimiter("\\A").next() : ""; 
			 scanner.close(); 
			 String[] params = queryString.split("&"); 
			 
			 for (String param : params) 
			 { 
				 String[] p = param.split("="); 
				 map.put(p[0], p[1]); 
			 } 
		 } 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		} 
		return map; 
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request); 
		
		String conId = paras.get("hidItemIDSave").toString();
		String name = paras.get("name").toString();
		String address = paras.get("address").toString();
		String mobile = paras.get("mobile").toString();
		String nic = paras.get("nic").toString();
		String email = paras.get("email").toString();
		String username = paras.get("username").toString();
		String password = paras.get("password").toString();
		
		String output = ConsumerDBUtill.updateProfileDetails(conId, name, address, mobile, nic, email, username, password);
		response.getWriter().write(output); 
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request); 
		String output = ConsumerDBUtill.deleteProfileDetails(paras.get("conId").toString()); 
		response.getWriter().write(output); 
		 
	}

}
