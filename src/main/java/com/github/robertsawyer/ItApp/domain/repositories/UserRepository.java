package com.github.robertsawyer.ItApp.domain.repositories;

import com.github.robertsawyer.ItApp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    User findFirstByLoginAndPassword(String login, String password);

    Optional<User> findFirstByLogin(String login);
}
