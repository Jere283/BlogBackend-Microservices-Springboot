package com.blog.futblog.DTO;

import lombok.Data;

@Data
public class LoginDTO {
    private String usernameOrEmail;
    private String clave;
}
