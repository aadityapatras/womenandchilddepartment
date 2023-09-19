package womenandchilddepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import womenandchilddepartment.dto.AdminDto;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.service.AdminService;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class AdminConroller {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create1")
    public ResponseEntity<String> createUserData(@Valid @RequestBody AdminDto adminDto) throws IOException {
        String userData = adminService.createAdminData(adminDto);
        return new ResponseEntity<>(userData, HttpStatus.CREATED);
    }
}