
# Employee Payroll System

This is a simple Spring Boot project for managing employee payroll.  
It supports CRUD operations and filtering employees by salary and department.

## Features
- Add new employees  
- View all employees  
- Update employee details  
- Delete employees  
- Find employees by salary, department, or salary range  

## Technologies Used
- Java  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Maven  

## How to Run
1. Clone the repository  
```

git clone [https://github.com/hindochahitarth/EmployeePayroll-Using-Spring.git](https://github.com/hindochahitarth/EmployeePayroll-Using-Spring.git)

```
2. Create a MySQL database  
```

CREATE DATABASE employee_db;

```
3. Update `application.properties` with your MySQL username and password.  
4. Run the project using  
```

mvn spring-boot:run

```
5. Open browser or Postman at  
```

[http://localhost:8080](http://localhost:8080)

```

## API Endpoints
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /api/employees | Add new employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |
| GET | /api/employees/salary/greater/{salary} | Salary greater than given value |
| GET | /api/employees/salary/less/{salary} | Salary less than given value |
| GET | /api/employees/salary/between/{min}/{max} | Salary between range |
| GET | /api/employees/department/{department} | Employees by department |
| GET | /api/employees/department/{department}/salary/{salary} | Department and salary filter |

## Developer
Hitarth Hindocha
```
