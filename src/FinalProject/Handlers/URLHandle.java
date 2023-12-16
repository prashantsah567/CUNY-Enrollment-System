package FinalProject.Handlers;

//this enum is to hold the various urls
public enum URLHandle {
	ERROR_LOGIN("/WEB-INF/errorHandlingFiles/loginError.jsp"),
	ERROR_DROP("/WEB-INF/errorHandlingFiles/enrollDropError.jsp"),
	ERROR_REGISTER("/WEB-INF/errorHandlingFiles/enrollRegisterError.jsp"),
	SUCCESS("myRegist.jsp"),
	SUCCESS_ENROLL("enroll.jsp");
	
	private String url;
	
	URLHandle(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
}
