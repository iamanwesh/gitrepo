package com.app.anwesh.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.anwesh.entity.Carshowroom;

public interface CarRepo extends CrudRepository<Carshowroom, String> {

}
