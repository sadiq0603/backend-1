package com.sloms.config;

import com.sloms.model.Admin;
import com.sloms.model.UserRole;
import com.sloms.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(AdminRepository adminRepository) {
        return args -> {
            if (adminRepository.count() == 0) {
                Admin admin = new Admin();
                admin.setName("D. Sadiq");
                admin.setEmail("sadiq123@gmail.com");
                admin.setPassword("sadiq@2007");
                admin.setRole(UserRole.ADMIN);
                adminRepository.save(admin);
                System.out.println("Default admin account created: sadiq123@gmail.com / sadiq@2007");
            }
        };
    }
}
