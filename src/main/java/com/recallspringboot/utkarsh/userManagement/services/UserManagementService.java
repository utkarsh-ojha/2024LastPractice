package com.recallspringboot.utkarsh.userManagement.services;

import com.recallspringboot.utkarsh.userManagement.entity.Users;

import java.util.List;

public interface UserManagementService {
    public Users createNewUser(Users user);

    public Users updateUser(Users user);

    public boolean deleteUser(long id);

    public List<Users> getAllUsers();
}
