package com.recallspringboot.utkarsh.userManagement.controller;

import com.recallspringboot.utkarsh.userManagement.entity.Users;
import com.recallspringboot.utkarsh.userManagement.servicesImpl.UserManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersManagementController {

    @Autowired
    UserManagementServiceImpl userManagementService;

    @PostMapping("/createUser")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(userManagementService.createNewUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> getUser() {
        return new ResponseEntity<>(userManagementService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        return new ResponseEntity<>(userManagementService.deleteUser(id), HttpStatus.GONE);
    }
}
