package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.MeetingAttendance;

import java.util.List;
import java.util.Optional;

public interface MeetingAttendanceService {

    List<MeetingAttendance> findAll();

    Optional<MeetingAttendance> findById(Long id);

    MeetingAttendance create(MeetingAttendance meetingAttendance);

    MeetingAttendance update(Long id, MeetingAttendance meetingAttendance);

    void delete(Long id);
}