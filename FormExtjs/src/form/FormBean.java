package form;

public class FormBean {
	private String firstname;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private int id;
	private String password;
	private String confpassword;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dob) {
		this.dateOfBirth = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	
}
