package com.blog.futblog.Services.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.EncuestasRepository;
import com.blog.futblog.Services.EncuestasService;

@Service
public class EncuestaImpl implements EncuestasService{

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired 
    EncuestasRepository encuestasRepository;

    @Override
    public Encuestas crearEncuesta(EncuestasDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        Encuestas encuesta = new Encuestas();
        encuesta.setTitulo(dto.getTitulo());
        encuesta.setEncuestausuario(usuario);

        /*List<Pregunta> preguntas = dto.getPreguntas();
        List<Pregunta> preguntasGuardadas = new ArrayList<>();

        for (Pregunta pregunta : preguntas) {
        Pregunta preguntaGuardada = preguntaRepository.save(pregunta);
        preguntasGuardadas.add(preguntaGuardada);
        }

        encuesta.setPreguntas(preguntasGuardadas);*/

        encuestasRepository.save(encuesta);

        return encuesta;
    }
    
}
