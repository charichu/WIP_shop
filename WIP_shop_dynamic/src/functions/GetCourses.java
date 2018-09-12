package functions;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import filtering.FilterProducts;

/**
 * Servlet implementation class GetProducts
 */
@WebServlet("/GetCourses")
public class GetCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// all shown rows as strings
		
		String courseNumber = null;
		String subject = request.getParameter("ddlSubject");
		subject = subject == ""? null : subject;
		String topic = null;
		String description = null;
		String studentType = null;
		String price = request.getParameter("txtPrice");
		int priceNum = Functions_Std.isStringNullOrEmpty(price)? -1 : Integer.parseInt(price);
		String capacity = request.getParameter("txtCapacity");
		int capacityNum = Functions_Std.isStringNullOrEmpty(capacity)? -1 : Integer.parseInt(capacity);
		String frequency = request.getParameter("ddlFrequency");
		frequency = frequency == ""? null : frequency;
		String duration = request.getParameter("txtDuration");
		int durationNum = Functions_Std.isStringNullOrEmpty(duration)? -1 : Integer.parseInt(duration);
		String addressID = null;
		String searchText = request.getParameter("srhCourses");
		searchText = searchText == ""? null : searchText;
		String grade = null;
		Course course;
		String site = null;
		// create array list, which go into the request
		ArrayList<Course> courses = new ArrayList<>();
		ResultSet rs = null;
		try {
			if(request.getParameter("filteredSite") == null){
				site = request.getParameter("targetSite");
				// execute sql statement
				rs = DBFunctions.Execute("select * from courses;");
			} else {
				site = request.getParameter("filteredSite");
				// execute filter sql statement
				
				FilterProducts filteredCourses = new FilterProducts(subject, topic, priceNum, capacityNum, frequency, durationNum, addressID, searchText);
				rs = filteredCourses.GetFilteredProducts();
			}
			
// fill the arraylist with rownames
        	courseNumber = "KursID";
        	subject = "Fach";
        	topic = "Thema";
        	description = "Beschreibung";
        	studentType = "Student/ Sch�ler";
        	price = "Preis";
        	frequency = "Frequenz";	
        	grade = "Jahrgangsstufe";	
        	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency,grade);
        	courses.add(course);
            	
// fill the arraylist with the return of the sql-statement
            while (rs.next()){
            	
            	courseNumber = rs.getString("courseid");
            	subject = rs.getString("subject");
            	topic = rs.getString("topic");
            	description = rs.getString("description");
            	studentType = rs.getString("studentType");
            	price = rs.getString("pricePerHour");
            	frequency = rs.getString("frequency");
            	grade = rs.getString("grade");
            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency, grade);
            	
            	courses.add(course);
            }
// write the arraylist into the request as attribute to get this on the jsp site
            request.setAttribute("courses", courses);
            request.getRequestDispatcher(site).forward(request, response);	          
        }
// exception handling
        catch (Exception e) {
            System.out.println("error " + e.getMessage());
            System.out.println(e.getStackTrace());
        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
