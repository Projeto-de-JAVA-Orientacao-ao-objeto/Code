package gofuture.acesso.controller;


import gofuture.acesso.pessoa.AdminRequestDTO;
import gofuture.acesso.repository.Admin;
import gofuture.acesso.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody AdminRequestDTO adminRequest) {
        Admin savedAdmin = adminService.saveAdmin(adminRequest);
        return ResponseEntity.ok(savedAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody AdminRequestDTO adminRequest) {
        Admin authenticatedAdmin = adminService.authenticate(adminRequest.login(), adminRequest.senha());
        return ResponseEntity.ok(authenticatedAdmin);
    }
}
