package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.EditUserDTO;
import com.github.robertsawyer.ItApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/edit-data")
    public String editUserDataForm(Model model) {

        model.addAttribute("editData", new EditUserDTO());
        return "/user/editUser";
    }

    @PostMapping("/edit-data")
    public String editUserData(@Valid @ModelAttribute("editData") EditUserDTO editUserDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "/user/editUser";
        }
        userService.editUserData(editUserDTO);
        return "redirect:/dashboard";
    }
}
