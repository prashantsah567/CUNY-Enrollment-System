package FinalProject.Interfaces;

import FinalProject.Beans.Course;
import java.util.List;

public interface CourseInterface {
	public List<Course> getCourses();
	public boolean addCourse(String ssn, String courseID, String grade);
	public boolean delCourse(String ssn, String courseID);
}
