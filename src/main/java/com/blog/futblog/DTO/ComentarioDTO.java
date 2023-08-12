package com.blog.futblog.DTO;

import lombok.Data;

@Data
public class ComentarioDTO {

    private String contenido;
    private Integer usuario;
    private Integer publicacion;
}
