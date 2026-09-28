package com.ob.bachatgat.repositorys;

import com.ob.bachatgat.entitys.InterestTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestTransactionRepository extends JpaRepository<InterestTransaction, Long> {
}