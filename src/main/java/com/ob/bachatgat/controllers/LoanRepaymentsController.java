package com.ob.bachatgat.controllers;

import com.ob.bachatgat.entitys.LoanRepayments;
import com.ob.bachatgat.services.LoanRepaymentsService;
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
@RequestMapping("/api/loan-repayments")
@RequiredArgsConstructor
public class LoanRepaymentsController {

    private final LoanRepaymentsService loanRepaymentsService;

    @GetMapping
    public ResponseEntity<List<LoanRepayments>> findAll() {
        return ResponseEntity.ok(loanRepaymentsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRepayments> findById(@PathVariable Long id) {
        return loanRepaymentsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoanRepayments> create(@RequestBody LoanRepayments loanRepayments) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanRepaymentsService.create(loanRepayments));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanRepayments> update(@PathVariable Long id, @RequestBody LoanRepayments loanRepayments) {
        if (loanRepaymentsService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loanRepaymentsService.update(id, loanRepayments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (loanRepaymentsService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        loanRepaymentsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}