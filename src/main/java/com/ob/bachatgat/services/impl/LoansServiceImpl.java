package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Loans;
import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.repositorys.LoansRepository;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.services.LoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    private final LoansRepository loansRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Loans> findAll() {
        return loansRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Loans> findById(Long id) {
        return loansRepository.findById(id);
    }

    @Override
    @Transactional
    public Loans create(Loans loans) {
        loans.setMemberId(resolveMember(loans));
        return loansRepository.save(loans);
    }

    @Override
    @Transactional
    public Loans update(Long id, Loans loans) {
        Loans existing = loansRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Loans not found with id: " + id));
        existing.setMemberId(resolveMember(loans));
        existing.setLoanNumber(loans.getLoanNumber());
        existing.setLoanAmount(loans.getLoanAmount());
        existing.setInterestRate(loans.getInterestRate());
        existing.setStartDate(loans.getStartDate());
        existing.setDueDate(loans.getDueDate());
        existing.setTotalInterest(loans.getTotalInterest());
        existing.setOutstandingPrincipal(loans.getOutstandingPrincipal());
        existing.setOutstandingInterest(loans.getOutstandingInterest());
        existing.setApprovedAt(loans.getApprovedAt());
        existing.setApprovedBy(loans.getApprovedBy());
        return loansRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Loans existing = loansRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Loans not found with id: " + id));
        loansRepository.delete(existing);
    }

    private Members resolveMember(Loans loans) {
        Members member = loans.getMemberId();
        if (member == null || member.getMemberId() == null) {
            return null;
        }
        return membersRepository.getReferenceById(member.getMemberId());
    }
}