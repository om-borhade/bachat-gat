package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Loans;

import java.util.List;
import java.util.Optional;

public interface LoansService {

    List<Loans> findAll();

    Optional<Loans> findById(Long id);

    Loans create(Loans loans);

    Loans update(Long id, Loans loans);

    void delete(Long id);
}