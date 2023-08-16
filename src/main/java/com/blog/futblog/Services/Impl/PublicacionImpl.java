package com.blog.futblog.Services.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Categorias;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.CategoriasRepository;
import com.blog.futblog.Repository.LikeRepository;
import com.blog.futblog.Repository.PublicacionRepository;
import com.blog.futblog.Services.PublicacionService;

@Service
public class PublicacionImpl implements PublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Publicacion savePublicacion(PublicacionDTO dto) {
        User usuario = usuarioImpl.findUserById(dto.getUsuario());
        Publicacion publicacion = new Publicacion();
        publicacion.setContenido(dto.getContenido());
        List<Integer> categoriaIds = dto.getCategoriaIds();
        List<Categorias> categorias = new ArrayList<>();

        // TODO descomentar esta parte para poder agregar categorias
        Categorias categoria = categoriasRepository.findById(1).orElse(null);
        categorias.add(categoria);
        /*
         * for (Integer categoriaId : categoriaIds) {
         * categorias.add(categoriasRepository.findById(categoriaId)
         * .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
         * }
         */
        // publicacion.setLikes(dto.getLikes());
        publicacion.setTitulo(dto.getTitulo());
        publicacion.setUsuario(usuario);
        publicacion.setCategorias(categorias);

        publicacionRepository.save(publicacion);

        return publicacion;

    }

    @Override
    public List<Publicacion> getAllPublicaciones() {
        List<Publicacion> publicaciones = (List<Publicacion>) publicacionRepository.findAll();

        Collections.sort(publicaciones,
                (p1, p2) -> Integer.compare(likeRepository.countLikesByPublicacionId(p2.getId()),
                        likeRepository.countLikesByPublicacionId(p1.getId())));

        return publicaciones;

    }

    @Override
    public Publicacion getPublicacionById(Integer id) {
        Publicacion publicacion = publicacionRepository.findById(id).orElse(null);

        return publicacion;
    }

    @Override
    public List<Publicacion> getAllPublicacionsFromUser(Integer userID) {
        User user = usuarioImpl.findUserById(userID);

        if (user == null) {
            return null;
        }

        List<Publicacion> publicacionesDeUsuario = user.getPublicaciones();

        return publicacionesDeUsuario;

    }

    @Override
    public List<Categorias> obtenerCategoriasDePublicacion(Integer publicacionId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        return publicacion.getCategorias();
    }

    @Override
    public String eliminarPublicacion(Integer id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

        publicacionRepository.delete(publicacion);

        return "Publicación con ID " + id + " ha sido eliminada";
    }

    public Integer contarPublicacionesPorUsuarioId(Integer usuarioId) {
        return publicacionRepository.countPublicacionesByUsuarioId(usuarioId);
    }

}
