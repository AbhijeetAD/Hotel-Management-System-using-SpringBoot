package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Manager;

import com.example.demo.exceptionhandling.ManagerNotFoundException;
import com.example.demo.service.ManagerService;



import jakarta.validation.Valid;

@RestController

public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/manager")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager createdManager = managerService.createManager(manager);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @PutMapping("/manager/{managerId}")
    public ResponseEntity<Manager> updateManager(
            @PathVariable int managerId,
            @RequestBody Manager updatedManager) {
        try {
            Manager updated = managerService.updateManager(managerId, updatedManager);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ManagerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/manager/{managerId}")
    public ResponseEntity<Void> deleteManager(@PathVariable int managerId) {
        managerService.deleteManager(managerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<Manager> getManagerById(@PathVariable int managerId) {
        try {
            Manager manager = managerService.getManagerById(managerId);
            return new ResponseEntity<>(manager, HttpStatus.OK);
        } catch (ManagerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/managers")
    public ResponseEntity<Iterable<Manager>> getAllManagers() {
        Iterable<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }
}