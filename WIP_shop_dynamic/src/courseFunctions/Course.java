package courseFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import functions.DBFunctions;
/**
 * This is the class for the course.
 * @author werner
 * 
 */
public class Course {
	
	private String courseNumber;
	private String subject;
	private String topic;
	private String description;
	private String studentType;
	private String pricePerHour;
	private Double capacity;
	private String capacityDescription;
	private String frequency;
	private Double durationPerMeeting;
	private String durationPerMeetingDescription;
	private int addressID;
	private int userID;
	private String grade;
	private Double pricePerMeeting;
	private boolean active;
	
	public Course(Integer courseID){
		try {
			String sqlStatement = DBFunctions.CreateSelectQuery("courses", new String[]{"*"}, "courseID="+courseID.toString());
			ResultSet rs = DBFunctions.Execute(sqlStatement);
            if (rs.next()) {
            	this.courseNumber = courseID.toString();
        		this.subject = rs.getString("subject");
        		this.description = rs.getString("description");
        		this.studentType = rs.getString("studentType");
        		this.pricePerHour = rs.getString("pricePerHour");
        		this.capacity = rs.getDouble("capacity");
        		this.frequency = rs.getString("frequency");
        		this.durationPerMeeting = rs.getDouble("durationPerMeeting");
        		this.addressID = rs.getInt("addressID");
        		this.userID = rs.getInt("userID");
        		this.grade = rs.getString("grade");
        		this.active = rs.getBoolean("active");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Constuctor to set the description
	 */
	public Course(){
		this.courseNumber = "Kurs Nummer";
		this.subject = "Fach";
		this.topic = "Thema";
		this.description = "Beschreibung";
		this.studentType = "Student/ Schüler";
		this.pricePerHour = "Stundenpreis";
		this.capacityDescription = "Kapazität";
		this.frequency = "Frequenz";
		this.durationPerMeetingDescription = "Dauer pro Treffen";
		this.grade = "Jahrgangsstufe";
	}
	public Course(String couseNumber, String subject, String topic, String description, String studentType,
			String price, String frequency, String grade) {
		super();
		this.courseNumber = couseNumber;
		this.subject = subject;
		this.topic = topic;
		this.description = description;
		this.studentType = studentType;
		this.pricePerHour = price;
		this.frequency = frequency;
		this.grade = grade;
	}
	
	public Course(String courseNumber, String subject, String topic, String description, String studentType,
			String pricePerHour, Double capacity, String frequency, Double durationPerMeeting, int addressID,
			int userID, String grade) {
		super();
		this.courseNumber = courseNumber;
		this.subject = subject;
		this.topic = topic;
		this.description = description;
		this.studentType = studentType;
		this.pricePerHour = pricePerHour;
		this.capacity = capacity;
		this.frequency = frequency;
		this.durationPerMeeting = durationPerMeeting;
		this.addressID = addressID;
		this.userID = userID;
		this.grade = grade;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(String pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Double getDurationPerMeeting() {
		return durationPerMeeting;
	}

	public void setDurationPerMeeting(Double durationPerMeeting) {
		this.durationPerMeeting = durationPerMeeting;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getCapacityDescription() {
		return capacityDescription;
	}
	public void setCapacityDescription(String capacityDescription) {
		this.capacityDescription = capacityDescription;
	}
	public String getDurationPerMeetingDescription() {
		return durationPerMeetingDescription;
	}
	public void setDurationPerMeetingDescription(String durationPerMeetingDescription) {
		this.durationPerMeetingDescription = durationPerMeetingDescription;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Double getPricePerMeeting(){
		pricePerMeeting=Integer.parseInt(pricePerHour)*(durationPerMeeting/60);
		return pricePerMeeting;
	}
	
}
