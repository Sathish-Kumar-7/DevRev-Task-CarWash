package com.devrev.assignment.carwash.repository;

import com.devrev.assignment.carwash.entity.Booking;
import com.devrev.assignment.carwash.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepo extends JpaRepository<Credentials,Long> {
    Optional<Credentials> findCredentialsByEmailAddress(String email);

    Optional<Credentials> findCredentialsByUserName(String username);

    Boolean existsCredentialsByUserNameAndUserPassword(String username,String password);
}
