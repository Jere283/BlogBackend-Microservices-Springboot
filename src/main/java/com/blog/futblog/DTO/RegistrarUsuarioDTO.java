package com.blog.futblog.DTO;

import lombok.Data;

@Data
public class RegistrarUsuarioDTO {
    private String nombre;

    private String username;

    private String email;

    private String clave;
}
