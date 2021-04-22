package ru.director.SpringDiaryLern.dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class Dao<E, K> {

    public Dao() {

    }

    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);




}


