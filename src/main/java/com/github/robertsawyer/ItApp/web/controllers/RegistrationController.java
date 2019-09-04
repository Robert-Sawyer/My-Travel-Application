package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.RegistrationFormDTO;
import com.github.robertsawyer.ItApp.dtos.UserDTO;
import com.github.robertsawyer.ItApp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO()); //mogłoby być tylko new RFDTO bez stringa (zielony tekst) (tak samo niżej zamiast model attribute, a wtedy w widoku jsp trzeba zmienić modelattribute na rfdto
        return "registration-page";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO form, BindingResult result){
        if (result.hasErrors()){
            return "registration-page";
        }
        if(!checkPasswordEquality(form)){
            result.rejectValue("password", null, "Hasło i powtórzone hasło niezgodne");
            return "registration-page";
        }
        if(!checkIsUsernameIsAvailable(form)){
            result.rejectValue("login", null, "Nazwa użytkownika już zajęta");
            return "registration-page";
        }
        //Konwersja rfDTO na user encja i wywołąnie userrepositiry.save(...);
        userService.registerUser(form);
        return "redirect:/home";
    }

    private boolean checkIsUsernameIsAvailable(RegistrationFormDTO form) {
        // Alt + 6 wyświetla wszystkie to do
        UserDTO user = userService.findUser(form.getLogin());
        if (user == null) {
            return true;
        }
        return false;
    }

    private boolean checkPasswordEquality(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmPassword());
    }


}
//ctrl + tab wraca do poprzedniej karty