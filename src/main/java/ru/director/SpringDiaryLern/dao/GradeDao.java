package ru.director.SpringDiaryLern.dao;

import ru.director.SpringDiaryLern.model.Credential;
import ru.director.SpringDiaryLern.model.Grade;

import java.sql.*;
import java.util.List;


public class GradeDao extends Dao<Grade, String> {

    Long  gradeId;
    String gradeName;


    Credential credential = new Credential();

    public GradeDao(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        credential.getCredentials(credential);
        String sql = "SELECT * FROM GRADE WHERE ID = (?)";
        try (Connection connection =  DriverManager.getConnection(credential.getUrl(), credential.getUsername(), credential.getPassword())) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, gradeId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                gradeName = rs.getString(2);
                System.out.println("Successfully get  grade name " + rs.getLong(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Disconnected from the PostgreSQL server successfully!");
        }
        return gradeName;

    }

    @Override
    public List<Grade> getAll() {
        return null;
    }

    @Override
    public Grade getEntityById(String id) {
        return null;
    }

    @Override
    public Grade update(Grade entity) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean create(Grade entity) {
        return false;
    }
}
