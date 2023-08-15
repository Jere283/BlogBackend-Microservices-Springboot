package com.blog.futblog.DTO;

import java.util.List;

import com.blog.futblog.Models.Preguntas;

import lombok.Data;

@Data
public class EncuestasDTO {
    private String titulo;
    private Integer usuario;
    private List<Preguntas> preguntas;
}
