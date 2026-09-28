package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Members;

import java.util.List;
import java.util.Optional;

public interface MembersService {

    List<Members> findAll();

    Optional<Members> findById(Long id);

    Members create(Members members);

    Members update(Long id, Members members);

    void delete(Long id);
}