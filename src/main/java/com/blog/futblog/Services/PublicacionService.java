package com.blog.futblog.Services;

import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Publicacion;

public interface PublicacionService {

    public Publicacion savePublicacion(PublicacionDTO dto);
}
