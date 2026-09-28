package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.InterestTransaction;
import com.ob.bachatgat.entitys.Loans;
import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.repositorys.InterestTransactionRepository;
import com.ob.bachatgat.repositorys.LoansRepository;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.services.InterestTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterestTransactionServiceImpl implements InterestTransactionService {

    private final InterestTransactionRepository interestTransactionRepository;
    private final LoansRepository loansRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InterestTransaction> findAll() {
        return interestTransactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InterestTransaction> findById(Long id) {
        return interestTransactionRepository.findById(id);
    }

    @Override
    @Transactional
    public InterestTransaction create(InterestTransaction interestTransaction) {
        interestTransaction.setLoan(resolveLoan(interestTransaction));
        interestTransaction.setMember(resolveMember(interestTransaction));
        return interestTransactionRepository.save(interestTransaction);
    }

    @Override
    @Transactional
    public InterestTransaction update(Long id, InterestTransaction interestTransaction) {
        InterestTransaction existing = interestTransactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("InterestTransaction not found with id: " + id));
        existing.setLoan(resolveLoan(interestTransaction));
        existing.setMember(resolveMember(interestTransaction));
        existing.setInterestAmount(interestTransaction.getInterestAmount());
        existing.setCalculatedDate(interestTransaction.getCalculatedDate());
        existing.setPaidAmount(interestTransaction.getPaidAmount());
        existing.setPendingAmount(interestTransaction.getPendingAmount());
        return interestTransactionRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        InterestTransaction existing = interestTransactionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("InterestTransaction not found with id: " + id));
        interestTransactionRepository.delete(existing);
    }

    private Loans resolveLoan(InterestTransaction interestTransaction) {
        Loans loan = interestTransaction.getLoan();
        if (loan == null || loan.getLoanId() == null) {
            return null;
        }
        return loansRepository.getReferenceById(loan.getLoanId());
    }

    private Members resolveMember(InterestTransaction interestTransaction) {
        Members member = interestTransaction.getMember();
        if (member == null || member.getMemberId() == null) {
            return null;
        }
        return membersRepository.getReferenceById(member.getMemberId());
    }
}