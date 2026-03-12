package studentinformationsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        conn = DBConnection.getConnection();
    }

    // This ensures we have a live connection before every operation
    private void checkConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DBConnection.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student s) {
        checkConnection();
        String sql = "INSERT INTO students (first_name, last_name, age, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getFirstName());
            pstmt.setString(2, s.getLastName());
            pstmt.setInt(3, s.getAge());
            pstmt.setString(4, s.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Add Error: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        checkConnection();
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setAge(rs.getInt("age"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Fetch Error: " + e.getMessage());
        }
        return list;
    }

    public void deleteStudent(int id) {
        checkConnection();
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
    public void updateStudent(Student s) {
    checkConnection();
    String sql = "UPDATE students SET first_name=?, last_name=?, age=?, email=? WHERE student_id=?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, s.getFirstName());
        pstmt.setString(2, s.getLastName());
        pstmt.setInt(3, s.getAge());
        pstmt.setString(4, s.getEmail());
        pstmt.setInt(5, s.getStudentId());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Update Error: " + e.getMessage());
    }
}
    
}