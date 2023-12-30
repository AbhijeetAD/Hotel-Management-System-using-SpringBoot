package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Manager;
import com.example.demo.exceptionhandling.ManagerNotFoundException;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(int managerId, Manager updatedManager) {
        Manager existingManager = managerRepository.findById(managerId).orElse(null);

        if (existingManager != null) {
            existingManager.setManagerName(updatedManager.getManagerName());
            existingManager.setEmail(updatedManager.getEmail());
            existingManager.setPhoneNumber(updatedManager.getPhoneNumber());

            return managerRepository.save(existingManager);
        } else {
            throw new ManagerNotFoundException(managerId);
        }
    }

    @Override
    public void deleteManager(int managerId) {
        managerRepository.deleteById(managerId);
    }

    @Override
    public Manager getManagerById(int managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new ManagerNotFoundException(managerId));
    }

    @Override
    public Iterable<Manager> getAllManagers() {
        return managerRepository.findAll();
    }
}