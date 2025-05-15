package com.mycompany.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcStudentDao implements StudentDao {

    private final DataSource dataSource;

    public JdbcStudentDao(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT (ID, NAME, EMAIL_ADDRESS) " + "VALUES (?, ?, ?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getemailAddr());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Student findByStudentName(String name) {
        String sql = "SELECT * FROM STUDENT WHERE NAME = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            Student student = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("ID"),
                        rs.getString("NAME"), rs.getString("EMAIL_ADDRESS"));
            }
            rs.close();
            ps.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void update (Student student) {
        String sql = "UPDATE STUDENT SET NAME=?, EMAIL_ADDRESS=? WHERE ID=?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getemailAddr());
            ps.setInt(3, student.getId());            
            System.out.println("ID = " + student.getId() + "NAME = " + student.getName() + 
                               "EMAIL = " + student.getemailAddr());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }

    public Student findByStudentId(int id) {
        String sql = "SELECT * FROM STUDENT WHERE ID = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Student student = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("ID"),
                        rs.getString("NAME"), rs.getString("EMAIL_ADDRESS"));
            }
            rs.close();
            ps.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public void delete(Student student) {
        String sql = "DELETE FROM STUDENT WHERE ID=?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "55"); 
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }
}
