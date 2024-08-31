package com.book.my.show.bookmyshowonline.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLogInRequestDTO {
    private String email;
    private String password;
}
