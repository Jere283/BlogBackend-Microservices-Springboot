package com.blog.futblog.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Models.Preguntas;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.EncuestasRepository;
import com.blog.futblog.Repository.PreguntasRepository;
import com.blog.futblog.Services.EncuestasService;

@Service
public class EncuestaImpl implements EncuestasService {

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired
    EncuestasRepository encuestasRepository;

    @Autowired
    PreguntasRepository preguntasRepository;

    @Override
    public Encuestas crearEncuesta(EncuestasDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        Encuestas encuesta = new Encuestas();
        encuesta.setTitulo(dto.getTitulo());
        encuesta.setEncuestausuario(usuario);

        encuesta = encuestasRepository.save(encuesta);

        List<Preguntas> preguntas = dto.getPreguntas();
        List<Preguntas> preguntasGuardadas = new ArrayList<>();

        for (Preguntas pregunta : preguntas) {

            pregunta.setPreguntaEncuesta(encuesta);

            Preguntas preguntaGuardada = preguntasRepository.save(pregunta);
            preguntasGuardadas.add(preguntaGuardada);
        }

        encuesta.setPreguntas(preguntasGuardadas);

        encuestasRepository.save(encuesta);

        return encuesta;
    }

    @Override
    public List<Encuestas> getAllEncuetsas() {
        List<Encuestas> encuestas = (List<Encuestas>) encuestasRepository.findAll();
        return encuestas;
    }

    @Override
    public String eliminarEncuesta(Integer id) {
        Encuestas encuestas = encuestasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada"));

        encuestasRepository.delete(encuestas);

        return "Encuesta con ID " + id + "ha sido eliminada";
    }

    @Override
    public Encuestas getEncuestasById(Integer id) {
        Encuestas encuestas = encuestasRepository.findById(id).orElse(null);
        return encuestas;
    }

}
