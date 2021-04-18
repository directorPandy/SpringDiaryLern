package ru.director.SpringDiaryLern.dao;

import ru.director.SpringDiaryLern.connectionControllers.ConnectionModule;
import ru.director.SpringDiaryLern.model.Grade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GradeDao extends Dao<Grade, String> {

    Long  gradeId;
    String gradeName;

    public GradeDao(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() throws SQLException {

        ConnectionModule connectionModule = new ConnectionModule();
        String sql = "SELECT * FROM GRADE WHERE ID = (?)";
        PreparedStatement ps = getPreparedStatement(sql, connectionModule);
        ps.setLong(1, gradeId);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gradeName = rs.getString(2);
                System.out.println("Successfully get  grade name " + rs.getLong(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
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
