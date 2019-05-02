package com.github.robertsawyer.ItApp.services;

import com.github.robertsawyer.ItApp.dtos.ContactFormDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    @Transactional
    public void sendMessage(ContactFormDTO contactFormDTO){

    }
}
