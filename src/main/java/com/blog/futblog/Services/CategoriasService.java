package com.blog.futblog.Services;

import com.blog.futblog.Models.Categorias;
import java.util.List;
public interface CategoriasService {
    List<Categorias> obtenerTodasCategorias();

    Categorias crearCategoria(String categoria);

    Categorias obtenerCategoriaPorId(Integer id);

    void eliminarCategoriaPorId(Integer id);
}
