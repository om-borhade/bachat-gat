package com.ob.bachatgat.repositorys;

import com.ob.bachatgat.entitys.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {
}