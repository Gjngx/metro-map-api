package com.example.metromapapi.controllers;

import com.example.metromapapi.models.Role;
import com.example.metromapapi.models.User;
import com.example.metromapapi.repositories.RoleRepository;
import com.example.metromapapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/v1/admins")
public class AdminController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("")
    List<User> getAllAdmins(){
        return userRepository.findAll();
    }
    @GetMapping("/roles")
    List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
