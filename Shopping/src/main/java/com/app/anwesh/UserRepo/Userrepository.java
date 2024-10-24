package com.app.anwesh.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.anwesh.Entity.UserRegistration;

public interface Userrepository extends JpaRepository<UserRegistration, Long> {

}
