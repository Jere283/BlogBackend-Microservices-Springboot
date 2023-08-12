package com.blog.futblog.Services;

import java.util.List;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Models.Comentario;

public interface ComentarioService {

    public Comentario saveComentario(ComentarioDTO dto);

    public List<Comentario> getComentariosByPublicacion(Integer idPublicacion);
}
