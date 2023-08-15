package com.blog.futblog.Services;

import java.util.List;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Models.Publicacion;

public interface EncuestasService {
    public Encuestas crearEncuesta(EncuestasDTO dto);

    public String eliminarEncuesta(Integer id);

    public List<Encuestas> getAllEncuetsas();

    public Encuestas getEncuestasById(Integer id);
}
