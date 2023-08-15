package com.blog.futblog.Services;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Models.Publicacion;

public interface EncuestasService {
    public Encuestas crearEncuesta(EncuestasDTO dto);
}
