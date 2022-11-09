package com.devrev.assignment.carwash.repository;

import com.devrev.assignment.carwash.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    Optional<Admin> findAdminByAdminEmail(String email);

    Boolean existsAdminByUsernameAndPassword(String username, String password);

}
