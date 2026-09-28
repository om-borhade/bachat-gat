package com.ob.bachatgat.services;

import com.ob.bachatgat.entitys.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {

    List<Meeting> findAll();

    Optional<Meeting> findById(Long id);

    Meeting create(Meeting meeting);

    Meeting update(Long id, Meeting meeting);

    void delete(Long id);
}