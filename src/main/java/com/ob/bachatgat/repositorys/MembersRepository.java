package com.ob.bachatgat.repositorys;

import com.ob.bachatgat.entitys.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
}