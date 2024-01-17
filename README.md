# CUNY Enrollment System 

-> CUNY Enrollment System is the final project for the CST4713 class, showcasing dynamic web development with JSP and Servlets. 
The project follows a full-stack Java-based approach, implementing the MVC architecture with distinct layers for UI, Business Class, and Data Access.

## Major Requirements

1. regisLogin.jsp should ask user's ssn number (student's ssn in our database used in class) and move to validateLogin.java servlet.
2. Must have all database-related codes isolated into DBUtil.java under DBUtils package.
3. All Beans (attached) should be used and they should be under Beans package.
4. If the student exists in the Student table in the database, your validateLogin servlet will move to myRegist.jsp that displays all classes registered as below picture.
5. If the student doesn't exist, your validateLogin servlet will move to loginError.jsp that displays "[SSN] doesn't exist in our database" and the link to go back to regisLogin.jsp. 
6. Enroll button should move to registerClass.java servlet to get data and show in the enroll.jsp.
7. Drop button should move to dropClass.java servlet and go back to myRegist.jsp if successful. If not, enrollDropError.jsp.
8. Make sure you have 3 interface classes, 3 business classes, and 1 database class(DBUtil.java).
9. Your program should not have any comliation error(s). You won't get partial credit at all if there is any compliation error.
10. All java files should be under the package "FinalProject".
11. Do not use any javascript in your JSP files.

![CST4713_FinalProject](https://github.com/prashantsah567/CUNY-Enrollment-System/assets/82275480/5919754e-57d3-4043-a75e-84964f769d3b)

## Architecture

The project is structured as follows:

```
|-- CUNY-Enrollment-System
    |-- src
        |-- FinalProject
            |-- Beans
            |-- DBUtils
            |-- Handlers
            |-- Interfaces
            |-- Servlets
    |-- ...
    |-- WebContent
        |-- CSS
        |-- WEB-INF
            |-- ErrorHandlingFiles
        |-- JSP
        |-- ...
    |-- ...
```

## Major Features

1. **Login and Validation**: Users provide their SSN on regisLogin.jsp, which is then validated through the validateLogin servlet.

2. **Database Isolation**: Database-related code is encapsulated in DBUtil.java within the DBUtils package, promoting clean architecture.

3. **Bean Usage**: The project utilizes Beans (e.g., EnrollBean) stored in the Beans package for structured data handling.

4. **Dynamic UI**: The myRegist.jsp page displays all classes registered by a student, providing a comprehensive view of their enrollment.

5. **Error Handling**: In case of a non-existing student, loginError.jsp informs the user, directing them back to regisLogin.jsp and other errors are handled in a similar fashion.

6. **Enrollment and Dropping**: The Enroll button triggers registerClass.java to gather data and present it in enroll.jsp. The Drop button connects to dropClass.java, returning to myRegist.jsp upon success or enrollDropError.jsp in case of an issue.

7. **Interface and Business Classes**: The project adheres to best practices with three interface classes, three business classes, and a centralized database class (DBUtil.java).

8. **Error-Free Compilation**: Strict adherence to coding standards ensures a compilation error-free codebase.

## Tech Stack

### Frontend:
- **JavaServer Pages (JSP):** Used for dynamic content generation and presentation.
- **CSS (Cascading Style Sheets):** Provides styling and layout for the user interface.

### Backend:
- **Java Servlets:** Handle server-side processing and act as controllers in the MVC architecture.
- **JavaBeans:** Used for encapsulating and organizing data structures.
- **Java Database Connectivity (JDBC):** Facilitates interaction with the MySQL database.

### Database:
- **MySQL:** A relational database management system used to store and retrieve student and course-related data.

### Development Environment:
- **Eclipse:** Integrated development environment (IDE) for Java development.
- **JavaEE:** Java Platform, Enterprise Edition, for building enterprise-level applications.

### Version Control:
- **Git:** Used for version control, facilitating collaboration, and code management.

### Project Management:
- **GitHub:** Platform for hosting the project repository, version control, and collaboration.

### Architecture:
- **MVC (Model-View-Controller):** A design pattern separating the application into three interconnected components for a more modular and scalable structure.

### Deployment:
- **Local Server:** The project was deployed on a local server during development and testing.

### Other:
- **JDBC Driver for MySQL:** Enables Java applications to interact with the MySQL database using JDBC.

### Login Screen
<img width="1350" alt="Screen Shot 2023-12-16 at 11 48 07" src="https://github.com/prashantsah567/CUNY-Enrollment-System/assets/82275480/81affb82-7e69-45c0-8f72-ac3ffc7b0bb9">

### Student Info Screen
<img width="1434" alt="Screen Shot 2023-12-16 at 11 46 06" src="https://github.com/prashantsah567/CUNY-Enrollment-System/assets/82275480/a1a2e939-12e0-4de4-881e-771291440498">

### Enrollment Screen
<img width="1059" alt="Screen Shot 2023-12-16 at 11 46 30" src="https://github.com/prashantsah567/CUNY-Enrollment-System/assets/82275480/026e166d-a605-4394-abc0-8b95ac391521">

# Running the Project

1. Clone the repository to your local machine.
2. Open the project in Eclipse with JavaEE support.

Feel free to explore the code and enhance it based on your requirements. If any issues arise, refer to the guidelines above or contact me.

Happy coding!
