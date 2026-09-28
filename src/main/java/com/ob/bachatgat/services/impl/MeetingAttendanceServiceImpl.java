package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Meeting;
import com.ob.bachatgat.entitys.MeetingAttendance;
import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.repositorys.MeetingAttendanceRepository;
import com.ob.bachatgat.repositorys.MeetingRepository;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.services.MeetingAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingAttendanceServiceImpl implements MeetingAttendanceService {

    private final MeetingAttendanceRepository meetingAttendanceRepository;
    private final MeetingRepository meetingRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MeetingAttendance> findAll() {
        return meetingAttendanceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MeetingAttendance> findById(Long id) {
        return meetingAttendanceRepository.findById(id);
    }

    @Override
    @Transactional
    public MeetingAttendance create(MeetingAttendance meetingAttendance) {
        meetingAttendance.setMeetingsId(resolveMeeting(meetingAttendance));
        meetingAttendance.setMember(resolveMember(meetingAttendance));
        return meetingAttendanceRepository.save(meetingAttendance);
    }

    @Override
    @Transactional
    public MeetingAttendance update(Long id, MeetingAttendance meetingAttendance) {
        MeetingAttendance existing = meetingAttendanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MeetingAttendance not found with id: " + id));
        existing.setMeetingsId(resolveMeeting(meetingAttendance));
        existing.setMember(resolveMember(meetingAttendance));
        existing.setAttendanceStatus(meetingAttendance.getAttendanceStatus());
        existing.setRemarks(meetingAttendance.getRemarks());
        return meetingAttendanceRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        MeetingAttendance existing = meetingAttendanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MeetingAttendance not found with id: " + id));
        meetingAttendanceRepository.delete(existing);
    }

    private Meeting resolveMeeting(MeetingAttendance meetingAttendance) {
        Meeting meeting = meetingAttendance.getMeetingsId();
        if (meeting == null || meeting.getMeetingId() == null) {
            return null;
        }
        return meetingRepository.getReferenceById(meeting.getMeetingId());
    }

    private Members resolveMember(MeetingAttendance meetingAttendance) {
        Members member = meetingAttendance.getMember();
        if (member == null || member.getMemberId() == null) {
            return null;
        }
        return membersRepository.getReferenceById(member.getMemberId());
    }
}