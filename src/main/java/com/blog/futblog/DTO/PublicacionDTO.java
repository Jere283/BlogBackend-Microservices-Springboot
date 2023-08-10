package com.blog.futblog.DTO;

import lombok.Data;

@Data
public class PublicacionDTO {
    private String titulo;
    private String contenido;
    private Integer likes;
    private Integer usuario;
}
