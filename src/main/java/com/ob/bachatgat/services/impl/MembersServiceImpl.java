package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Members;
import com.ob.bachatgat.repositorys.MembersRepository;
import com.ob.bachatgat.services.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Members> findAll() {
        return membersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Members> findById(Long id) {
        return membersRepository.findById(id);
    }

    @Override
    @Transactional
    public Members create(Members members) {
        return membersRepository.save(members);
    }

    @Override
    @Transactional
    public Members update(Long id, Members members) {
        Members existing = membersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Members not found with id: " + id));
        existing.setMemberCode(members.getMemberCode());
        existing.setMemberName(members.getMemberName());
        existing.setPhoneNumber(members.getPhoneNumber());
        existing.setAddress(members.getAddress());
        existing.setJoiningDate(members.getJoiningDate());
        return membersRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Members existing = membersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Members not found with id: " + id));
        membersRepository.delete(existing);
    }
}