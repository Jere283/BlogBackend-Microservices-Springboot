package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.LikeDTO;
import com.blog.futblog.Models.Like;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.LikeRepository;
import com.blog.futblog.Repository.PublicacionRepository;
import com.blog.futblog.Repository.UsuarioRepository;
import com.blog.futblog.Services.LikeService;

@Service
public class LikeImpl implements LikeService{

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
    public Like guardarLike(int publicacionId, int usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
        .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
        User user = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Like like=new Like();
        like.setLikeusuario(user);
        like.setLikepublicacion(publicacion);
        likeRepository.save(like);
        return like;
    }

    @Override
    public void eliminarLikePorId(int likeId) {
    Like like = likeRepository.findById(likeId)
        .orElseThrow(() -> new RuntimeException("Like no encontrado"));

    likeRepository.delete(like);
    }

    
}
