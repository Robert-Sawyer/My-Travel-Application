package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.User;
import com.github.robertsawyer.ItApp.domain.repositories.UserRepository;
import com.github.robertsawyer.ItApp.dtos.RegistrationFormDTO;
import com.github.robertsawyer.ItApp.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);  //Converters. bo metody są statyczne

        logger.info("Rejestracja usera: " + user);
            userRepository.save(user);
            logger.info("Zarejestrowany użytkownik: " + user);
    }


    public UserDTO findUser(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser = userRepository.findByLogin(login);
        User user = optionalUser.orElse(null); //opakowujemy usera w obiekt optional.

        if (user == null) {
            logger.info("Znaleziono usera dla nazwy: " + login);
            return null;
        }
        logger.info("Znaleziono usera dla nazwy: " + login + ": " + user);

        return Converters.convertToUserDTO(user);
    }


}
