package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.Models.Preguntas;
import com.blog.futblog.Models.User;
import com.blog.futblog.Models.Votacion;
import com.blog.futblog.Repository.PreguntasRepository;
import com.blog.futblog.Repository.UsuarioRepository;
import com.blog.futblog.Repository.VotacionRepository;
import com.blog.futblog.Services.VotacionService;

@Service
public class VotacionImpl implements VotacionService{

    @Autowired
    VotacionRepository votacionRepository;

    @Autowired UsuarioImpl usuarioImpl;

    @Autowired
    PreguntasRepository preguntasRepository;

    @Autowired 
    UsuarioRepository usuarioRepository;

    @Override
    public int countVotesForPregunta(int preguntaId) {
        return votacionRepository.countLikesByPreguntaId(preguntaId);
    }

    @Override
    public String guardarVoto(int preguntaId, int usuarioId) {
        Preguntas preguntas = preguntasRepository.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Votacion votacion = new Votacion();
        votacion.setVotacionusuario(user);
        votacion.setVotacionpregunta(preguntas);
        votacionRepository.save(votacion);
        String nUsuario = user.getNombre();
        String nPregunta = preguntas.getPregunta();
        return nUsuario + " voto en la pregunta: " + nPregunta;
    }

    @Override
    public void eliminarVotoById(int votoId) {
        Votacion votacion = votacionRepository.findById(votoId)
        .orElseThrow(() -> new RuntimeException("Like no encontrado"));
        votacionRepository.delete(votacion);
    }

    @Override
    public String quitarVoto(int preguntaId, int usuarioId) {
        Preguntas preguntas = preguntasRepository.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Votacion votacion = votacionRepository.findByVotacionusuarioAndVotacionpregunta(user, preguntas);
        votacionRepository.delete(votacion);
        String nUsuario = user.getNombre();
        String nPregunta = preguntas.getPregunta();
        return nUsuario + " quito el voto en la pregunta: " + nPregunta;
    }

    @Override
    public Boolean comporbar(int preguntaId, int usuarioId) {
        Preguntas preguntas = preguntasRepository.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Votacion votacion = votacionRepository.findByVotacionusuarioAndVotacionpregunta(user, preguntas);
        Boolean mensaje;
        if (votacion != null) {
            mensaje = true;
        } else {
            mensaje = false;
        }
        return mensaje;
    }

    @Override
    public Integer countVotesByUsuarioId(Integer usuarioId) {
        return votacionRepository.countVotosByUsuarioId(usuarioId);
    }
    
}
