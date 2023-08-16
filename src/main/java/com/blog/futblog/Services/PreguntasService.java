package com.blog.futblog.Services;

import java.util.List;

import com.blog.futblog.DTO.PreguntasDTO;
import com.blog.futblog.Models.Preguntas;

public interface PreguntasService {
    public Preguntas savePreguntas(PreguntasDTO dto);

    public Preguntas guarardPreguntas(int EncuestaId, PreguntasDTO preguntasDTO);

    public List<Preguntas> getPreguntasByEncuesta(Integer idEncuesta);

    Integer countPreguntasByUsuarioId(Integer usuarioId);
}
