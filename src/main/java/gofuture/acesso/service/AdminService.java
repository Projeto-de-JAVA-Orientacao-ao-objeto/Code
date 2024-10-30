package gofuture.acesso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gofuture.acesso.pessoa.AdminRequestDTO;
import gofuture.acesso.repository.Admin;
import gofuture.acesso.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin saveAdmin(AdminRequestDTO adminRequest) {
        Admin admin = new Admin(adminRequest.login(), adminRequest.senha());
        return adminRepository.save(admin);
    }

    public Admin authenticate(String login, String senha) {
        Admin admin = adminRepository.findByLogin(login);
        if (admin != null && admin.getSenha().equals(senha)) {
            return admin;
        }
        throw new RuntimeException("Invalid login or password");
    }
}
