package com.blog.futblog.Services;

public interface LikeService {
    public int countLikesForPublicacion(int publicacionId);

    public String guardarLike(int publicacionId, int usuarioId);

    public void eliminarLikePorId(int likeId);

    public String quitarLike(int publicacionId, int usuarioId);

    public Boolean comporbar(int publicacionId, int usuarioId);

}
