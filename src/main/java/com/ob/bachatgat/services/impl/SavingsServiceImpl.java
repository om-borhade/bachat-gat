package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.entitys.Savings;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.repositorys.SavingsRepository;
import com.ob.bachatgat.services.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;
    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Savings> findAll() {
        return savingsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Savings> findById(Long id) {
        return savingsRepository.findById(id);
    }

    @Override
    @Transactional
    public Savings create(Savings savings) {
        savings.setMemberId(resolveMember(savings));
        return savingsRepository.save(savings);
    }

    @Override
    @Transactional
    public Savings update(Long id, Savings savings) {
        Savings existing = savingsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Savings not found with id: " + id));
        existing.setMemberId(resolveMember(savings));
        existing.setAmount(savings.getAmount());
        existing.setSavingMonth(savings.getSavingMonth());
        existing.setPaymentDate(savings.getPaymentDate());
        existing.setPaymentReference(savings.getPaymentReference());
        return savingsRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Savings existing = savingsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Savings not found with id: " + id));
        savingsRepository.delete(existing);
    }

    private Members resolveMember(Savings savings) {
        Members member = savings.getMemberId();
        if (member == null || member.getMemberId() == null) {
            return null;
        }
        return membersRepository.getReferenceById(member.getMemberId());
    }
}