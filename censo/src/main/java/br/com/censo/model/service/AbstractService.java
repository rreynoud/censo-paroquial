package br.com.censo.model.service;


import java.io.Serializable;
import java.util.List;

import br.com.censo.model.AbstractEntity;
import br.com.censo.model.dao.AbstractDAO;


public abstract class AbstractService<PK, T extends AbstractEntity> implements Serializable {

    public abstract AbstractDAO<PK, T> getDAO();

    public T save(T entity) throws Exception {
        return this.getDAO().save(entity);
    }

    public T update(T entity) throws Exception {
        return this.getDAO().update(entity);
    }

    public T delete(T entity) throws Exception {
        return this.getDAO().delete(entity);
    }

    public T deleteById(PK pk) throws Exception {
        return this.getDAO().delete(this.getDAO().getById(pk));
    }

    public T getById(PK pk) {
        return this.getDAO().getById(pk);
    }

    public T getByProperty(String propertyName, String propertyValue) {
        return this.getDAO().getByProperty(propertyName, propertyValue);
    }

    public T getByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName,
                                String secondPropertyValue) {
        T entity = null;
        try {
            entity = this.getDAO().getByTwoProperties(firstPropertyName, firstPropertyValue, secondPropertyName,
                    secondPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> listByProperty(String propertyName, String propertyValue) {
        List<T> entity = null;
        try {
            entity = this.getDAO().listByProperty(propertyName, propertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> findAll() {
        return this.getDAO().findAll();
    }

}