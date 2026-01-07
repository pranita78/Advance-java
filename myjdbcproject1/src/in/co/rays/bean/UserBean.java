package in.co.rays.bean;

import java.sql.Date;

public class UserBean extends BaseBean {
	
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String ConfirmPassword;
	private java.util.Date dob;
	private String mobilNO;
	private long roleId;
	private String gender;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date date) {
		this.dob = date;
	}
	public String getMobilNO() {
		return mobilNO;
	}
	public void setMobilNO(String mobilNO) {
		this.mobilNO = mobilNO;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
