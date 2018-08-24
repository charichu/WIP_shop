package registration;

import java.util.Date;

public class Registration {
	private String email;
	private String username;
	private String password;
	private Boolean teacher;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String schoolClass;
	private boolean student;
	private String address;
	
	public Registration(String email, String username, String password, Boolean teacher, String firstName, String lastName, Boolean student, String address) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.teacher = teacher;
		this.student = student;
		this.address = address;
	}
	
	
}
