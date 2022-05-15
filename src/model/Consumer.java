package model;

public class Consumer {

	public String conId;
	public String name;
	public String address;
	public String nic;
	public String mobile;
	public String email;
	public String username;
	public String password;
	
	
	public Consumer(String conId, String name, String address, String nic, String mobile, String email,
			String username, String password) {
		super();
		this.conId = conId;
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public String getconId() {
		return conId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getNic() {
		return nic;
	}
	public String getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}