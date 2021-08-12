package com.rest.restapi.dao;

import com.rest.restapi.Entities.bookClass;

import org.springframework.data.repository.CrudRepository;

public interface bookRepo extends CrudRepository<bookClass,Integer> {
    public bookClass findById(int id);
}
