package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Savings;

import java.util.List;
import java.util.Optional;

public interface SavingsService {

    List<Savings> findAll();

    Optional<Savings> findById(Long id);

    Savings create(Savings savings);

    Savings update(Long id, Savings savings);

    void delete(Long id);
}