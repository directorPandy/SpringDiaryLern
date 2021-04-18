package ru.director.SpringDiaryLern.dao;




import ru.director.SpringDiaryLern.connectionControllers.ConnectionModule;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<E, K> {

    ConnectionModule connection = null;

    public ConnectionModule AbstractControllerConnect() {

        connection.connect();
        return connection;
    }


    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    public PreparedStatement getPreparedStatement(String sql, ConnectionModule connection){
        PreparedStatement ps = null;
        try{
            ps = connection.connect().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }


}


