package FinalProject.Interfaces;

import java.util.List;
import FinalProject.Beans.EnrollBean;

public interface EnrollmentInterface {
	public List<EnrollBean> getStudentCourses(String ssn);
}
