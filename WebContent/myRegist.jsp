<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="FinalProject.Beans.EnrollBean" %>
<% List<EnrollBean> enroll = (List<EnrollBean>) request.getAttribute("enroll");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/myRegist.css">
    <title>Student Information</title>
</head>
<body>
    <div class="info-section">
        <h2>Student Information</h2>
        <div class="info-row">
            <div><strong>SSN:</strong> ${student.ssn}</div>
            <div><strong>Name:</strong> ${student.fname} ${student.lname}</div>
        </div>
        <div class="info-row">
            <div><strong>Address:</strong> ${student.address}, ${student.zip}</div>
            <div><strong>Phone Number:</strong> ${student.phone}</div>
        </div>
        <div><strong>Department:</strong> ${student.deptId}</div>
    </div>

    <div class="enrollment-section">
        <h2>My Classes:</h2>
        <table>
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Title</th>
                    <th>Grade</th>
                </tr>
            </thead>
            <tbody>
                <% for (EnrollBean e : enroll) { %>
                    <tr>
                        <td><%= e.getCourseID() %></td>
                        <td><%= e.getTitle() %></td>
                        <td><%= e.getGrade() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
	
	<div class="button-container">
		<form action="registLogin.jsp" method="post" class="button-form">
	        <button type="submit" class="exit-button">Exit</button>
	    </form>
	
	    <form action="register-class" method="post" class="button-form">
	        <button type="submit" class="enroll-button">Enroll</button>
	    </form>
	</div>
</body>
</html>
