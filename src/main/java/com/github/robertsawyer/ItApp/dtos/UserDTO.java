package com.github.robertsawyer.ItApp.dtos;

import com.github.robertsawyer.ItApp.domain.model.UserDetails;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String login;
    private UserDetails details;


}
