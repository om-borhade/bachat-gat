package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users create(Users users);

    Users update(Long id, Users users);

    void delete(Long id);
}