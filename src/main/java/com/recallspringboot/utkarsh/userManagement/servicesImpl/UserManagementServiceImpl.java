package com.recallspringboot.utkarsh.userManagement.servicesImpl;

import com.recallspringboot.utkarsh.userManagement.entity.Users;
import com.recallspringboot.utkarsh.userManagement.repository.UserRepository;
import com.recallspringboot.utkarsh.userManagement.services.UserManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    final UserRepository userRepository;

    public UserManagementServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users createNewUser(Users inputUser) {
        return userRepository.save(inputUser);
    }

    @Override
    public Users updateUser(Users inputUser) {
        Optional<Users> obtainedUserInfo = checkIfUserExists(inputUser.getId());

        if (obtainedUserInfo.isPresent()) {
            Users existingUser = obtainedUserInfo.get();
            existingUser.setEmail(inputUser.getEmail());
            existingUser.setUsername(inputUser.getUsername());
            existingUser.setPassword(inputUser.getPassword());
            return userRepository.save(existingUser);
        } else return null;
    }

    @Override
    public boolean deleteUser(long id) {
        Optional<Users> obtainedUserInfo = checkIfUserExists(id);
        if (obtainedUserInfo.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> checkIfUserExists(long id) {
        return userRepository.getUsersById(id);
    }
}
