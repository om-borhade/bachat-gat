package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.MeetingAttendance;
import com.ob.bachatgat.services.MeetingAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meeting-attendances")
@RequiredArgsConstructor
public class MeetingAttendanceController {

    private final MeetingAttendanceService meetingAttendanceService;

    @GetMapping
    public ResponseEntity<List<MeetingAttendance>> findAll() {
        return ResponseEntity.ok(meetingAttendanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingAttendance> findById(@PathVariable Long id) {
        return meetingAttendanceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MeetingAttendance> create(@RequestBody MeetingAttendance meetingAttendance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(meetingAttendanceService.create(meetingAttendance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingAttendance> update(@PathVariable Long id, @RequestBody MeetingAttendance meetingAttendance) {
        if (meetingAttendanceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meetingAttendanceService.update(id, meetingAttendance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (meetingAttendanceService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        meetingAttendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}