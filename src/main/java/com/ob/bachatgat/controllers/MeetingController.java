package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.Meeting;
import com.ob.bachatgat.services.MeetingService;
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
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping
    public ResponseEntity<List<Meeting>> findAll() {
        return ResponseEntity.ok(meetingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> findById(@PathVariable Long id) {
        return meetingService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Meeting> create(@RequestBody Meeting meeting) {
        return ResponseEntity.status(HttpStatus.CREATED).body(meetingService.create(meeting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> update(@PathVariable Long id, @RequestBody Meeting meeting) {
        if (meetingService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(meetingService.update(id, meeting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (meetingService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        meetingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}