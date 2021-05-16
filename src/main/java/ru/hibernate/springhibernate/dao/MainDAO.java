package ru.hibernate.springhibernate.dao;

import ru.hibernate.springhibernate.dto.BillDTO;
import ru.hibernate.springhibernate.entity.Bill;

import java.util.List;

public interface MainDAO<T, D> {
    List<T> getAll();
    T save(D dest);
//    List<T> search(String... searchString);
//
//    T get(int id);

//    void delete(T object);
}
