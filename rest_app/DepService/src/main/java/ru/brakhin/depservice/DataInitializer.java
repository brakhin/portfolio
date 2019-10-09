package ru.brakhin.depservice;

import ru.brakhin.depservice.model.Service;
import ru.brakhin.depservice.model.User;
import ru.brakhin.depservice.repository.IServiceRepository;
import ru.brakhin.depservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository users;

    @Autowired
    IServiceRepository serviceRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (this.users.findAll().size() == 0) {
            this.users.save(User.builder()
                    .username("user")
                    .password(this.passwordEncoder.encode("password"))
                    .roles(Arrays.asList( "ROLE_USER"))
                    .build()
            );

            this.users.save(User.builder()
                    .username("admin")
                    .password(this.passwordEncoder.encode("password"))
                    .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                    .build()
            );

            log.debug("printing all users...");
            this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
        }

        if (!this.serviceRepository.findAll().iterator().hasNext()) {

            for (int i = 1; i < 10; i++) {
                serviceRepository.save(new Service("Услуга № " + i));
            }

        }

    }
}
