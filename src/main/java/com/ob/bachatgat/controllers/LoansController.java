package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.Loans;
import com.ob.bachatgat.services.LoansService;
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
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoansController {

    private final LoansService loansService;

    @GetMapping
    public ResponseEntity<List<Loans>> findAll() {
        return ResponseEntity.ok(loansService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loans> findById(@PathVariable Long id) {
        return loansService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Loans> create(@RequestBody Loans loans) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loansService.create(loans));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loans> update(@PathVariable Long id, @RequestBody Loans loans) {
        if (loansService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loansService.update(id, loans));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (loansService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        loansService.delete(id);
        return ResponseEntity.noContent().build();
    }
}