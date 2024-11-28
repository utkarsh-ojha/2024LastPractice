package com.recallspringboot.utkarsh.userManagement.repository;

import com.recallspringboot.utkarsh.userManagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByusername(String username);

    Optional<Users> getUsersById(long id);
}
