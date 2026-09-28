package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Meeting;
import com.ob.bachatgat.repositorys.MeetingRepository;
import com.ob.bachatgat.services.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Meeting> findById(Long id) {
        return meetingRepository.findById(id);
    }

    @Override
    @Transactional
    public Meeting create(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    @Transactional
    public Meeting update(Long id, Meeting meeting) {
        Meeting existing = meetingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Meeting not found with id: " + id));
        existing.setMeetingDate(meeting.getMeetingDate());
        existing.setMeetingTime(meeting.getMeetingTime());
        existing.setLocation(meeting.getLocation());
        existing.setAgenda(meeting.getAgenda());
        existing.setMinutes(meeting.getMinutes());
        existing.setCreatedBy(meeting.getCreatedBy());
        return meetingRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Meeting existing = meetingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Meeting not found with id: " + id));
        meetingRepository.delete(existing);
    }
}