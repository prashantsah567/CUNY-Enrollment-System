package FinalProject.Beans;

public class ClassesBean {
	final private String courseID, title;
	
	public ClassesBean(String courseID, String title){
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