package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.LoanRepayments;
import com.ob.bachatgat.entitys.Loans;
import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.repositorys.LoanRepaymentsRepository;
import com.ob.bachatgat.repositorys.LoansRepository;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.services.LoanRepaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanRepaymentsServiceImpl implements LoanRepaymentsService {

    private final LoanRepaymentsRepository loanRepaymentsRepository;
    private final LoansRepository loansRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LoanRepayments> findAll() {
        return loanRepaymentsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LoanRepayments> findById(Long id) {
        return loanRepaymentsRepository.findById(id);
    }

    @Override
    @Transactional
    public LoanRepayments create(LoanRepayments loanRepayments) {
        loanRepayments.setLoanId(resolveLoan(loanRepayments));
        loanRepayments.setMemberId(resolveMember(loanRepayments));
        return loanRepaymentsRepository.save(loanRepayments);
    }

    @Override
    @Transactional
    public LoanRepayments update(Long id, LoanRepayments loanRepayments) {
        LoanRepayments existing = loanRepaymentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LoanRepayments not found with id: " + id));
        existing.setLoanId(resolveLoan(loanRepayments));
        existing.setMemberId(resolveMember(loanRepayments));
        existing.setPaymentDate(loanRepayments.getPaymentDate());
        existing.setPrincipalAmount(loanRepayments.getPrincipalAmount());
        existing.setInterestAmount(loanRepayments.getInterestAmount());
        existing.setTotalAmount(loanRepayments.getTotalAmount());
        existing.setPaymentReference(loanRepayments.getPaymentReference());
        return loanRepaymentsRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        LoanRepayments existing = loanRepaymentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LoanRepayments not found with id: " + id));
        loanRepaymentsRepository.delete(existing);
    }

    private Loans resolveLoan(LoanRepayments loanRepayments) {
        Loans loan = loanRepayments.getLoanId();
        if (loan == null || loan.getLoanId() == null) {
            return null;
        }
        return loansRepository.getReferenceById(loan.getLoanId());
    }

    private Members resolveMember(LoanRepayments loanRepayments) {
        Members member = loanRepayments.getMemberId();
        if (member == null || member.getMemberId() == null) {
            return null;
        }
        return membersRepository.getReferenceById(member.getMemberId());
    }
}