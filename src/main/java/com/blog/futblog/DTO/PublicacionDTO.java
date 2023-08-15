package com.blog.futblog.DTO;

import java.util.List;
import lombok.Data;

@Data
public class PublicacionDTO {
    private String titulo;
    private String contenido;
    private Integer likes;
    private Integer usuario;
    private List<Integer> categoriaIds;
}
