package com.ob.bachatgat.repositorys;

import com.ob.bachatgat.entitys.MeetingAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingAttendanceRepository extends JpaRepository<MeetingAttendance, Long> {
}