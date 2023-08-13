package com.blog.futblog.Services;

import com.blog.futblog.Models.Like;
import com.blog.futblog.Models.Seguidores;

public interface SeguidoresService {
    public int contarSeguidores(int seguidoId);

    public int contarSeguidos(int seguidorId);

    public Seguidores Seguir(int seguidorId, int seguidoId);

    public String comporbarSeguimiento(int seguidorId, int seguidoId);

    public String eliminarSeguimiento(int seguidorId, int seguidoId);
}
