package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Models.Comentario;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.ComentarioRepository;
import com.blog.futblog.Services.ComentarioService;

@Service
public class ComentarioImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioImpl usuarioImpl;

    @Override
    public Comentario saveComentario(ComentarioDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());

        Comentario comentario = new Comentario();

        comentario.setContenido(dto.getContenido());
        comentario.setUsuario(usuario);

        comentarioRepository.save(comentario);

        return comentario;
    }

}
