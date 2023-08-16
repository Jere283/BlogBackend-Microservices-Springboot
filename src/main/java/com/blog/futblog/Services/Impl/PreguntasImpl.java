package com.blog.futblog.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.futblog.DTO.PreguntasDTO;
import com.blog.futblog.Models.Preguntas;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.EncuestasRepository;
import com.blog.futblog.Repository.PreguntasRepository;
import com.blog.futblog.Services.PreguntasService;

public class PreguntasImpl implements PreguntasService {

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired
    PreguntasRepository preguntasRepository;

    @Autowired
    private EncuestasRepository encuestasRepository;

    @Override
    public Preguntas savePreguntas(PreguntasDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        throw new UnsupportedOperationException("Unimplemented method 'savePreguntas'");
    }

    @Override
    public Preguntas guarardPreguntas(int EncuestaId, PreguntasDTO preguntasDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'guarardPreguntas'");
    }

    @Override
    public List<Preguntas> getPreguntasByEncuesta(Integer idEncuesta) {
        throw new UnsupportedOperationException("Unimplemented method 'getPreguntasByEncuesta'");
    }

    @Override
    public Integer countPreguntasByUsuarioId(Integer usuarioId) {
        throw new UnsupportedOperationException("Unimplemented method 'countPreguntasByUsuarioId'");
    }

}
