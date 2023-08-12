package com.blog.futblog.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Models.Comentario;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.ComentarioRepository;
import com.blog.futblog.Repository.PublicacionRepository;
import com.blog.futblog.Services.ComentarioService;

@Service
public class ComentarioImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired
    PublicacionImpl publicacionImpl;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public Comentario saveComentario(ComentarioDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        Publicacion publicacion = publicacionImpl.getPublicacionById(dto.getPublicacion());

        Comentario comentario = new Comentario();

        comentario.setContenido(dto.getContenido());
        comentario.setUsuario(usuario);
        comentario.setPublicacion(publicacion);

        comentarioRepository.save(comentario);

        return comentario;
    }

    @Override
    public List<Comentario> getComentariosByPublicacion(Integer idPublicacion) {

        Publicacion publicacion = publicacionImpl.getPublicacionById(idPublicacion);

        List<Comentario> comentarios = publicacion.getComentarios();

        return comentarios;

    }

    @Override
    public Comentario guarardComentarios(int publicacionId, ComentarioDTO comentarioDTO) {
        User usuario = usuarioImpl.findUserById(comentarioDTO.getUsuario());
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
        .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        Comentario comentario = new Comentario();
        comentario.setContenido(comentarioDTO.getContenido());
        comentario.setUsuario(usuario);
        comentario.setPublicacion(publicacion);

        comentarioRepository.save(comentario);
        return comentario;
    }

    

}
