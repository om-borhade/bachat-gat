package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.Savings;
import com.ob.bachatgat.services.SavingsService;
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
@RequestMapping("/api/savings")
@RequiredArgsConstructor
public class SavingsController {

    private final SavingsService savingsService;

    @GetMapping
    public ResponseEntity<List<Savings>> findAll() {
        return ResponseEntity.ok(savingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Savings> findById(@PathVariable Long id) {
        return savingsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Savings> create(@RequestBody Savings savings) {
        return ResponseEntity.status(HttpStatus.CREATED).body(savingsService.create(savings));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Savings> update(@PathVariable Long id, @RequestBody Savings savings) {
        if (savingsService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(savingsService.update(id, savings));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (savingsService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        savingsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}