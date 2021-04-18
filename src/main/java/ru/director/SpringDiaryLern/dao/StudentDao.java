package ru.director.SpringDiaryLern.dao;

import ru.director.SpringDiaryLern.connectionControllers.ConnectionModule;
import ru.director.SpringDiaryLern.model.Student;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StudentDao extends Dao<Student, Long> {

    Student student;
    Long gradeId;

    List<Student> students;
    List<String> studentsName = new ArrayList();

    public StudentDao(Student student) {
        this.student = student;
    }

    public StudentDao(List<Student> students) {
         this.students = students;
    }


    public List<String> getStudentNames() throws SQLException {

        for (Student student: students) {

            ConnectionModule connectionModule = new ConnectionModule();
            Long id;
            id = student.getId();
            String sql = "SELECT * FROM STUDENT WHERE ID = (?)";
            PreparedStatement ps = getPreparedStatement(sql, connectionModule);
            ps.setLong(1, id);
            try{
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    studentsName.add(rs.getString(2));
                    System.out.println("Successfully get student " + rs.getString(2));
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ps.close();
                System.out.println("Disconnected from the PostgreSQL server successfully.");
            }
        }return studentsName;

    }

    public Long getStudentGrade() throws SQLException {
        ConnectionModule connectionModule = new ConnectionModule();
        Long id = student.getId();

        String sql = "SELECT * FROM STUDENT WHERE ID = (?)";
        PreparedStatement ps = getPreparedStatement(sql, connectionModule);
        ps.setLong(1, id);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gradeId = rs.getLong(3);
                System.out.println("Successfully get student grade " + rs.getLong(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            System.out.println("Disconnected from the PostgreSQL server successfully!");
        }
        return gradeId;

    }


    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student getEntityById(Long id) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Student entity) {
        return false;
    }
}
