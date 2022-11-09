package com.devrev.assignment.carwash.controller;

import com.devrev.assignment.carwash.entity.Credentials;
import com.devrev.assignment.carwash.entity.Places;
import com.devrev.assignment.carwash.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "carwash/")
public class CredentialsController {
    @Autowired
    public final CredentialsService credentialsService;

    CredentialsController(CredentialsService credentialsService){
        this.credentialsService = credentialsService;
    }

    @PostMapping("/user/signup")
    public ResponseEntity<String> signUpNewUser(@RequestBody Credentials credentials){
        if (credentialsService.signUpNewUser(credentials))
            return new ResponseEntity<String>("User Successfully Added", HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Data");
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> loginExistingUser(@RequestBody Credentials credentials){
        if (credentialsService.loginExistingUser(credentials))
            return new ResponseEntity<String>("Login Successfully", HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Doesn't Exist");
    }

}
