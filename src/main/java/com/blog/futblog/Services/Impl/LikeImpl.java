package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.futblog.Models.Like;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.Seguidores;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.LikeRepository;
import com.blog.futblog.Repository.PublicacionRepository;
import com.blog.futblog.Repository.UsuarioRepository;
import com.blog.futblog.Services.LikeService;

@Service
public class LikeImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    UsuarioImpl usuarioImpl;

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public int countLikesForPublicacion(int publicacionId) {
        return likeRepository.countLikesByPublicacionId(publicacionId);
    }

    @Override
    public String guardarLike(int publicacionId, int usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Like like = new Like();
        like.setLikeusuario(user);
        like.setLikepublicacion(publicacion);
        likeRepository.save(like);
        String nUsuario=user.getNombre();
        String nPublicacion=publicacion.getTitulo();
        return nUsuario+ " dio like a la publicacion "+ nPublicacion;
    }

    @Override
    public Boolean comporbar(int publicacionId, int usuarioId) {
        User usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Like like = likeRepository.findByLikeusuarioAndLikepublicacion(usuario, publicacion);
        Boolean mensaje;
        if (like!=null) {
            mensaje=true;
        }else{
            mensaje=false;
        }
        return mensaje;
    }

    @Override
    public void eliminarLikePorId(int likeId) {
        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new RuntimeException("Like no encontrado"));

        likeRepository.delete(like);
    }

    @Override
    public String quitarLike(int publicacionId, int usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Like like = likeRepository.findByLikeusuarioAndLikepublicacion(user, publicacion);
        likeRepository.delete(like);
        String nUsuario=user.getNombre();
        String nPublicacion=publicacion.getTitulo();
        return nUsuario + " quitó el like a la publicacion: "+ nPublicacion;
    }

}
