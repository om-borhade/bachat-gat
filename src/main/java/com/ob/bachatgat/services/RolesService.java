package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesService {

    List<Roles> findAll();

    Optional<Roles> findById(Long id);

    Roles create(Roles roles);

    Roles update(Long id, Roles roles);

    void delete(Long id);
}