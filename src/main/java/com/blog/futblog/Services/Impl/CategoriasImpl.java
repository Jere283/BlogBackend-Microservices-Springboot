package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.blog.futblog.Models.Categorias;
import com.blog.futblog.Repository.CategoriasRepository;
import com.blog.futblog.Services.CategoriasService;

@Service
public class CategoriasImpl implements CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categorias> obtenerTodasCategorias() {
        return (List<Categorias>) categoriasRepository.findAll();
    }

    @Override
    public Categorias crearCategoria(String categoria) {
        Categorias categorias = new Categorias();
        categorias.setTitulo(categoria);
        return categoriasRepository.save(categorias);
    }

    @Override
    public Categorias obtenerCategoriaPorId(Integer id) {
        return categoriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public void eliminarCategoriaPorId(Integer id) {
        categoriasRepository.deleteById(id);
    }
}
