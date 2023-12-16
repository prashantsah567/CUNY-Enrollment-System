package FinalProject.Beans;

public class Course {
	private String courseID;
	private String title;
	
	public Course(String courseID, String title){
		this.courseID = courseID;
		this.title = title;
	}
	
	public String getCourseID() {
		return courseID;
	}
	public String getTitle() {
		return title;
	}
	
}
