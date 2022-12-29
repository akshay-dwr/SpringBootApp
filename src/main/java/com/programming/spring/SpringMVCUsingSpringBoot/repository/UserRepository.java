package com.programming.spring.SpringMVCUsingSpringBoot.repository;

import com.programming.spring.SpringMVCUsingSpringBoot.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    //no method needs to be written down for save functionality

    @Query("select u from User u where u.username = :name")
    public User searchByName(@Param("name") String username);
}

