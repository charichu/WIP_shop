package functions;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import functions.DBFunctions;

/**
 * the user of the wip_shop Tutor24; it use the {@link Address}
 * @author werner
 *
 */
public class User {
	private Integer userID;
	private String  username;
	private String  email;
	private Integer userType;
	private String  firstName;
	private String  lastName;
	private String  studentClass;
	private Date    dateOfBirth;
	private String  studentType;
	private String  qualificationProfile;
	private Integer addressID;
	private Double  grade;
	private boolean active;
	
	/**
	 * get the user out of the database with the userID
	 * @param userID
	 */
	public User(Integer userID) {
		String sqlStatement;
		if(userID != null){
			sqlStatement= DBFunctions.CreateSelectQuery("user", new String[]{"*"}, "userID = "+userID.toString());
			try {
				ResultSet rs = DBFunctions.Execute(sqlStatement);
				if(rs.next()){
					this.userID=rs.getInt("userID");
					userType= rs.getInt("userType");
					username = rs.getString("username");
					email = rs.getString("email");
					firstName = rs.getString("firstName");
					lastName = rs.getString("lastName");
					studentClass = rs.getString("class");
					dateOfBirth = rs.getDate("dateOfBirth");
					studentType = rs.getString("studentType");
					qualificationProfile = rs.getString("qualificationProfile");
					addressID = rs.getInt("addressID");
					grade    = rs.getDouble("class");
					active = rs.getBoolean("active");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
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
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStudentType() {
		return studentType;
	}
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}
	public String getQualificationProfile() {
		return qualificationProfile;
	}
	public void setQualificationProfile(String qualificationProfile) {
		this.qualificationProfile = qualificationProfile;
	}
	public Integer getAddressID() {
		return addressID;
	}
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * get the address out of the database<br>
	 * TODO replace the return parameter with the address class
	 * @return {@link HashMap} filled with the address fields
	 */
	public HashMap<String, String> getAddress() {
		String sqlStatement = DBFunctions.CreateSelectQuery("addresses", new String[]{"*"}, "addressID = "+addressID.toString());
		HashMap<String, String> address = new HashMap<String,String>();
		Integer addressID,plz,houseNumber;
		try {
			ResultSet rs = DBFunctions.Execute(sqlStatement);
			if (rs.next()) {
				addressID = rs.getInt("addressID");
				address.put("addressID", addressID.toString());
				address.put("city", rs.getString("city"));
				address.put("street", rs.getString("street"));
				houseNumber = rs.getInt("housenumber");
				address.put("houseNumber", houseNumber.toString());
				plz = rs.getInt("plz");
				address.put("plz", plz.toString());
			}
			return address;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String,String>();
		}
		
		
	}
	
}
