package courseFunctions;
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
	private String price;
	private String frequency;
	private String grade;
	
	public Course(String couseNumber, String subject, String topic, String description, String studentType,
			String price, String frequency, String grade) {
		super();
		this.courseNumber = couseNumber;
		this.subject = subject;
		this.topic = topic;
		this.description = description;
		this.studentType = studentType;
		this.price = price;
		this.frequency = frequency;
		this.grade = grade;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCouseNumber(String courseNumber) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
