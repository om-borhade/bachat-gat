package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.InterestTransaction;
import com.ob.bachatgat.services.InterestTransactionService;
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
@RequestMapping("/api/interest-transactions")
@RequiredArgsConstructor
public class InterestTransactionController {

    private final InterestTransactionService interestTransactionService;

    @GetMapping
    public ResponseEntity<List<InterestTransaction>> findAll() {
        return ResponseEntity.ok(interestTransactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestTransaction> findById(@PathVariable Long id) {
        return interestTransactionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InterestTransaction> create(@RequestBody InterestTransaction interestTransaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interestTransactionService.create(interestTransaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterestTransaction> update(@PathVariable Long id, @RequestBody InterestTransaction interestTransaction) {
        if (interestTransactionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(interestTransactionService.update(id, interestTransaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (interestTransactionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        interestTransactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}