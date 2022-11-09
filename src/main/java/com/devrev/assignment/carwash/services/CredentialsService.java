package com.devrev.assignment.carwash.services;

import com.devrev.assignment.carwash.entity.Credentials;
import com.devrev.assignment.carwash.repository.CredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class CredentialsService {
    private final CredentialsRepo credentialsRepo;
    @Autowired
    public CredentialsService(CredentialsRepo credentialsRepo){
        this.credentialsRepo = credentialsRepo;
    }
    public boolean signUpNewUser(Credentials credentials){
        Optional<Credentials> credentialsByEmail =  credentialsRepo.findCredentialsByEmailAddress(credentials.getEmailAddress());
        if (credentialsByEmail.isPresent())
            return false;
        else {
            credentialsRepo.save(credentials);
            return true;
        }
    }

    public boolean loginExistingUser(Credentials credentials) {
        return credentialsRepo
                .existsCredentialsByUserNameAndUserPassword(
                        credentials.getUserName(),
                        credentials.getUserPassword()
                );
    }
}
