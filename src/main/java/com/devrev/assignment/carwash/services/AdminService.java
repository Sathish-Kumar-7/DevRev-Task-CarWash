package com.devrev.assignment.carwash.services;

import com.devrev.assignment.carwash.entity.Admin;
import com.devrev.assignment.carwash.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    public final AdminRepo adminRepo;

    AdminService(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }

    public boolean signUpAdmin(Admin admin){
        Optional<Admin> adminByEmail =  adminRepo.findAdminByAdminEmail(admin.getAdminEmail());
        if (adminByEmail.isPresent())
            return false;
        else {
            adminRepo.save(admin);
            return true;
        }
    }

    public boolean loginExistingAdmin(Admin admin) {
        return adminRepo
                .existsAdminByUsernameAndPassword(
                        admin.getUsername(),
                        admin.getPassword()
                );
    }

}
