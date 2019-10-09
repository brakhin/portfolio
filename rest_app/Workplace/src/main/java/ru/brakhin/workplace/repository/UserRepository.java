package ru.brakhin.workplace.repository;

import org.springframework.data.repository.CrudRepository;
import ru.brakhin.workplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
