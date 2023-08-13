package com.blog.futblog.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.PublicacionRepository;
import com.blog.futblog.Services.PublicacionService;

@Service
public class PublicacionImpl implements PublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioImpl usuarioImpl;

    @Override
    public Publicacion savePublicacion(PublicacionDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        Publicacion publicacion = new Publicacion();
        publicacion.setContenido(dto.getContenido());
        //publicacion.setLikes(dto.getLikes());
        publicacion.setTitulo(dto.getTitulo());
        publicacion.setUsuario(usuario);

        publicacionRepository.save(publicacion);

        return publicacion;

    }

    @Override
    public List<Publicacion> getAllPublicaciones() {
        List<Publicacion> publicaciones = (List<Publicacion>) publicacionRepository.findAll();
        return publicaciones;
    }

    @Override
    public Publicacion getPublicacionById(Integer id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElse(null);

        return publicacion;
    }

    

}
