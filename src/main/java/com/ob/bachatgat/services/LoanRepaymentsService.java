package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.LoanRepayments;

import java.util.List;
import java.util.Optional;

public interface LoanRepaymentsService {

    List<LoanRepayments> findAll();

    Optional<LoanRepayments> findById(Long id);

    LoanRepayments create(LoanRepayments loanRepayments);

    LoanRepayments update(Long id, LoanRepayments loanRepayments);

    void delete(Long id);
}