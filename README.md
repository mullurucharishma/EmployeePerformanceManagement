# EmployeePerformanceManagement

This project implements a system for managing employee performance, including:
- Calculating and visualizing a bell curve for performance ratings.
- Suggesting adjustments to employee ratings based on deviations.
#Setup Instructions
**1. Clone the Repository**
git clone https://github.com/<your-username>/employee-performance-management.git
cd employee-performance-management
**2. Prerequisites**
- Java: Ensure Java 17 or later is installed.
- Maven: Install Maven for dependency management.
- Database:
H2 Database is pre-configured.
For MySQL, install and configure it (optional).
**3. Configure Database**
Default Configuration (H2 Database):
The project is pre-configured to use an H2 in-memory database. No additional setup is needed.
Switching to MySQL:
Install MySQL and create a database (e.g., employee_db).
**Update application.properties:**
#properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
Add the MySQL dependency to pom.xml:
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
**4. Build the Project**
Run the following command to download dependencies and compile the project:
mvn clean install
**5. Run the Application**
Start the application using Maven:
mvn spring-boot:run
The server will start at http://localhost:8080.
#Performance Management
**Method	Endpoint	Description**
POST	/employees	Add a new employee.
POST    /employees/categories
GET	    /employees/bell-curve	Get bell curve data.
GET	    /employees/suggestions	Get suggested adjustments.
GET     /employees/actual-percentages


