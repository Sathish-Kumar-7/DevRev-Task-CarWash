package com.devrev.assignment.carwash.controller;

import com.devrev.assignment.carwash.entity.Admin;
import com.devrev.assignment.carwash.entity.Credentials;
import com.devrev.assignment.carwash.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carwash/admin/")
public class AdminController {
    @Autowired
    public final AdminService adminService;

    AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpNewAdmin(@RequestBody Admin admin){
        if (adminService.signUpAdmin(admin))
            return new ResponseEntity<String>("Admin Successfully Added", HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Data");
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginExistingUser(@RequestBody Admin admin){
        if (adminService.loginExistingAdmin(admin))
            return new ResponseEntity<String>("Login Successfully", HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Username Or Password");
    }

}
