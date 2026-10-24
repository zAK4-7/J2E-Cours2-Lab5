package com.microservice.product.dao;

import java.util.List;

/**
 * Generic DAO contract: basic CRUD operations reusable for any entity type T.
 */
public interface IDao<T> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(Long id);
    List<T> findAll();
}
