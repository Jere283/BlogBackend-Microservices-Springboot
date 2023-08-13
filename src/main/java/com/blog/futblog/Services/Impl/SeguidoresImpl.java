package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.Models.Like;
import com.blog.futblog.Models.Seguidores;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.SeguidoresRepository;
import com.blog.futblog.Repository.UsuarioRepository;
import com.blog.futblog.Services.SeguidoresService;

@Service
public class SeguidoresImpl implements SeguidoresService{

    @Autowired
    SeguidoresRepository seguidoresRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public int contarSeguidores(int seguidoId) {
        return seguidoresRepository.countSeguidores(seguidoId);
    }

    @Override
    public int contarSeguidos(int seguidorId) {
        return seguidoresRepository.countSeguidos(seguidorId);
    }

    @Override
    public Seguidores Seguir(int seguidorId, int seguidoId) {
        User seguidor = usuarioRepository.findById(seguidorId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User seguido = usuarioRepository.findById(seguidoId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Seguidores seguidores = new Seguidores();
        seguidores.setSeguidorusuario(seguidor);
        seguidores.setSeguidousuario(seguido);
        seguidoresRepository.save(seguidores);
        return seguidores;
    }

    @Override
    public String comporbarSeguimiento(int seguidorId, int seguidoId) {
        User seguidor = usuarioRepository.findById(seguidorId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User seguido = usuarioRepository.findById(seguidoId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Seguidores seguidores= seguidoresRepository.findBySeguidorusuarioAndSeguidousuario(seguidor, seguido);
        String nombreseguidor=seguidor.getUsername();
        String nombreseguido=seguido.getUsername();
        String mensaje;
        if (seguidores!=null) {
            mensaje="El usuario: "+nombreseguidor+" sigue a: "+nombreseguido;
        }else{
            mensaje="El usuario: "+nombreseguidor+" no sigue a: "+nombreseguido;
        }
        return mensaje;
    }

    @Override
    public String eliminarSeguimiento(int seguidorId, int seguidoId) {
        User seguidor = usuarioRepository.findById(seguidorId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User seguido = usuarioRepository.findById(seguidoId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Seguidores seguidores= seguidoresRepository.findBySeguidorusuarioAndSeguidousuario(seguidor, seguido);
        seguidoresRepository.delete(seguidores);
        String nombreseguidor=seguidor.getUsername();
        String nombreseguido=seguido.getUsername();
        return nombreseguidor + " dejo de seguir a: "+ nombreseguido;    
    }

    
    
}
