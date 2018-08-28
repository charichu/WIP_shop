package functions;

public class Course {
	
	private String couseNumber;
	private String subject;
	private String topic;
	private String description;
	private String studentType;
	private String price;
	private String frequency;
	
	public Course(String couseNumber, String subject, String topic, String description, String studentType,
			String price, String frequency) {
		super();
		this.couseNumber = couseNumber;
		this.subject = subject;
		this.topic = topic;
		this.description = description;
		this.studentType = studentType;
		this.price = price;
		this.frequency = frequency;
	}
	
	public String getCouseNumber() {
		return couseNumber;
	}
	public void setCouseNumber(String couseNumber) {
		this.couseNumber = couseNumber;
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
}
