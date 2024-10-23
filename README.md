

# 🏢 **EmployeeManagement**

**EmployeeManagement** is a Spring Boot-based application designed to efficiently manage employee information and salary details. It offers intuitive features for employee registration, salary management, and secure role-based access (Developer, Manager, HR).

### 🚀 Core Features:

1. **🔐 User Authentication**  
   - Employees log in using their employee ID and password.  
   - Secure authentication is implemented using Spring Security, ensuring only authorized users can access the system.

2. **📝 Employee Registration**  
   - New users can register by submitting their name, employee ID, email, designation, and password.  
   - All employee data is securely stored in a relational database.

3. **💼 Designation-based Salary Calculation**  
   - The system retrieves predefined salary details from the database based on the employee’s role (e.g., Developer, Manager, Admin).  
   - Salary information is displayed after successful login.

4. **🛠 RESTful API Endpoints**  
   - `POST /register`: Register new employees with the required details.  
   - `POST /login`: Authenticate employees using their employee ID and password.  
   - `GET /salary/{id}`: Fetch salary details for an employee based on their ID.

5. **💾 Database Integration**  
   - Uses a relational database (MySQL/PostgreSQL) to store employee information, such as name, designation, email, and password.  
   - Salary details are stored in a separate table, linked via foreign keys to employee records.

6. **🧮 Salary Calculation Logic**  
   - Salary structures are defined based on the employee’s designation.  
   - Upon login, the system calculates and returns the salary based on the user's role.

7. **⚙️ Optional Admin Panel**  
   - Admins can manage employee records, update salary structures, and define roles.  
   - Admin access is protected by role-based authentication.

8. **🔒 Security**  
   - Passwords are securely hashed before being stored.  
   - Role-based access control ensures admins and regular users have appropriate permissions.  
   - All sensitive operations are safeguarded by Spring Security.

### 💻 Technologies Used:
- **Spring Boot** for building the backend.  
- **Spring Security** for secure authentication and authorization.  
- **MySQL/PostgreSQL** for database management.

