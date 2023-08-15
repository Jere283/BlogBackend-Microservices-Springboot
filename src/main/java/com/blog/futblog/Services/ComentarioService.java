package com.blog.futblog.Services;

import java.util.List;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Models.Comentario;

public interface ComentarioService {

    public Comentario saveComentario(ComentarioDTO dto);

    public Comentario guarardComentarios(int publicacionId, ComentarioDTO comentarioDTO);

    public List<Comentario> getComentariosByPublicacion(Integer idPublicacion);

    Integer countComentariosByUsuarioId(Integer usuarioId);
}
