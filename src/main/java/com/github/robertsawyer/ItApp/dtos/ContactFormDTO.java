package com.github.robertsawyer.ItApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactFormDTO {

    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String subject;
    @NotBlank
    private String textMessage;
}
