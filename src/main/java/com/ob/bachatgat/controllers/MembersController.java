package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.services.MembersService;
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
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @GetMapping
    public ResponseEntity<List<Members>> findAll() {
        return ResponseEntity.ok(membersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Members> findById(@PathVariable Long id) {
        return membersService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Members> create(@RequestBody Members members) {
        return ResponseEntity.status(HttpStatus.CREATED).body(membersService.create(members));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Members> update(@PathVariable Long id, @RequestBody Members members) {
        if (membersService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(membersService.update(id, members));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (membersService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        membersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}