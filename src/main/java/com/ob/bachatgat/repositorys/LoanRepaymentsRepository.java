package com.ob.bachatgat.repositorys;

import com.ob.bachatgat.entitys.LoanRepayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepaymentsRepository extends JpaRepository<LoanRepayments, Long> {
}