package com.ob.bachatgat.services.impl;

import com.ob.bachatgat.entitys.Users;
import com.ob.bachatgat.repositorys.UsersRepository;
import com.ob.bachatgat.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    @Transactional
    public Users create(Users users) {
        return usersRepository.save(users);
    }

    @Override
    @Transactional
    public Users update(Long id, Users users) {
        Users existing = usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Users not found with id: " + id));
        existing.setUserName(users.getUserName());
        existing.setPassword(users.getPassword());
        existing.setRoleId(users.getRoleId());
        return usersRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Users existing = usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Users not found with id: " + id));
        usersRepository.delete(existing);
    }
}