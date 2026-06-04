package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Users;

public interface IUserRepo extends JpaRepository<Users, String> {

	Users findByName(String userName);

}
