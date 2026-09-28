package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.InterestTransaction;

import java.util.List;
import java.util.Optional;

public interface InterestTransactionService {

    List<InterestTransaction> findAll();

    Optional<InterestTransaction> findById(Long id);

    InterestTransaction create(InterestTransaction interestTransaction);

    InterestTransaction update(Long id, InterestTransaction interestTransaction);

    void delete(Long id);
}