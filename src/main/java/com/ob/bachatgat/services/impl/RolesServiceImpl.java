package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Roles;
import com.ob.bachatgat.repositorys.RolesRepository;
import com.ob.bachatgat.services.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    @Transactional
    public Roles create(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    @Transactional
    public Roles update(Long id, Roles roles) {
        Roles existing = rolesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Roles not found with id: " + id));
        existing.setRoleName(roles.getRoleName());
        return rolesRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Roles existing = rolesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Roles not found with id: " + id));
        rolesRepository.delete(existing);
    }
}