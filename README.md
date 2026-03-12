

---

# Student Information System (SIS)

## Overview

The goal of this project is to develop a simple **Student Information System (SIS)** using **Java**, **MySQL**, and **NetBeans**. It performs standard **CRUD** (Create, Read, Update, Delete) operations and features a user interface for seamless interaction.

## Requirements

* 
**IDE**: NetBeans 


* 
**Database**: MySQL Workbench (Version 8.0.25 or 8.0.11) 


* 
**Java Version**: Java 8 or later 


* 
**Dependencies**: MySQL JDBC Driver (Connector/J) 



## Database Setup

To set up the database for this application, run the following SQL commands in your MySQL Workbench:

```sql
-- Create the database
[cite_start]CREATE DATABASE student_information_system; [cite: 28]

-- Select the database
[cite_start]USE student_information_system; [cite: 31]

-- Create the students table
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    age INT,
    email VARCHAR(100)
[cite_start]); [cite: 31]

```

## Features

The system supports the following CRUD operations:

1. 
**Create**: Add a new student record (first name, last name, age, email) into the database.


2. 
**Read**: Retrieve and display a list of all students from the database.


3. 
**Update**: Modify existing student information.


4. 
**Delete**: Remove a student record based on their unique `student_id`.



## Project Structure

* 
`DBConnection.java`: Manages the connection to the MySQL database.


* 
`Student.java`: Represents the student object with attributes for ID, name, age, and email.


* 
`StudentDAO.java`: Handles all database logic and CRUD operations.


* 
`StudentForm.java`: Java Swing GUI for user interaction.



## Installation & Configuration

1. 
**Clone the Repository**: Download the source code to your local machine.


2. 
**Add JDBC Driver**: Right-click the project in NetBeans, go to **Properties** > **Libraries**, and add the `mysql-connector-java-x.x.xx.jar` file.


3. 
**Update Credentials**: Open `DBConnection.java` and replace `"your_password"` with your actual MySQL root password.



---

