package com.github.robertsawyer.ItApp.web.controllers;

import com.github.robertsawyer.ItApp.dtos.ContactFormDTO;
import com.github.robertsawyer.ItApp.services.ContactService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/contact")
public class ContactController {

//    private MailSender mailSender;
//
//    private ContactService contactService;
//
//    @GetMapping
//    public String preparecContactPage(Model model){
//        model.addAttribute("contact", new ContactFormDTO());
//        return "contact";
//    }
//
//    @PostMapping
//    public String sendMail(@Valid @ModelAttribute("contact") ContactFormDTO contactFormDTO, BindingResult result) {
//        if(result.hasErrors()){
//            return "contact";
//        }
//        contactService.sendMessage(contactFormDTO);
//        return "contact";
//    }

//    @GetMapping
//    @ResponseBody
//    public String sendMail2(@RequestParam String message){
//
//        return "Wysłano";
//    }

    // Wstrzykujemy bean'a typu MailSender. Spring automatycznie dostarczy poprawną implementację
    // na podstawie ustawień w pliku application.properties

    private MailSender mailSender;

    public ContactController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping
    @ResponseBody
    public String sendMail(@RequestParam String recipient) {
        // Tworzymy obiekt typu SimpeMailMessage i ustawiamy w nim to, czego potrzebujemy
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setFrom("Kubuś Puchatek");
        message.setSubject("Test wysyłki");
        message.setText("Jakie to wszystko jest proste :) ");

        // Wysyłamy obiekt typu SimpleMimeMessage z użyciem bean'a MailSender
        mailSender.send(message);
        return "Wysłano!";

    }


}
