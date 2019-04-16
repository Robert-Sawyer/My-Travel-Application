package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.domain.model.User;
import com.github.robertsawyer.ItApp.dtos.RegistrationFormDTO;
import com.github.robertsawyer.ItApp.dtos.UserDTO;

public class Converters {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        return user;
    }
}
