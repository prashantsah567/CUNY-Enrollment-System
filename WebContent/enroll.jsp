<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="FinalProject.Beans.Course" %>
<% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/enroll.css">
    <title>Enrollment</title>
</head>
<body>
<form action="enroll-page-redirector">

    <div class="enrollment-section">
        
        	<!-- Course Combo Box -->
        	
            <label for="course">Courses: </label>
            <select id="course" name="course">
                <% for (Course c : courses) { %>
                    <option value="<%= c.getCourseID() %>"><%= c.getTitle() %></option>
                <% } %>
            </select>
            </br>
            <!-- Grade Combo Box -->
            
            <label for="grade">Grade:</label>
            <select id="grade" name="grade">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
                <option value="E">E</option>
                <option value="F">F</option>
            </select>

            <!-- Buttons -->
            <div class="button-form">
                <button type="submit" class="exit-button" name="action" value="exit">Exit</button>
                <button type="submit" class="drop-button" name="action" value="drop">Drop</button>
                <button type="submit" class="register-button" name="action" value="register">Register</button>
            </div>
    </div>
    
</form>
</body>
</html>

