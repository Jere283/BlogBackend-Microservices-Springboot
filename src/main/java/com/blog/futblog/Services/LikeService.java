package com.blog.futblog.Services;

import com.blog.futblog.Models.Like;

public interface LikeService {
    public int countLikesForPublicacion(int publicacionId);

    public Like guardarLike(int publicacionId, int usuarioId);

    public void eliminarLikePorId(int likeId);

}
