package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.blog.futblog.DTO.CategoriaDTO;
import com.blog.futblog.Models.Categorias;
import com.blog.futblog.Services.CategoriasService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping("/all")
    public ResponseEntity<List<Categorias>> obtenerTodasCategorias() {
        List<Categorias> categorias = categoriasService.obtenerTodasCategorias();
        return ResponseEntity.ok(categorias);
    }

    //Solo se envia el titulo de la categoria
    @PostMapping("/crear/{categoria}")
    public ResponseEntity<String> crearCategoria(@PathVariable String categoria) {
        categoriasService.crearCategoria(categoria);
        String mensaje = "Categoría '" + categoria + "' ha sido creada correctamente.";
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/eliminar/{categoriaId}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer categoriaId) {
        Categorias categoriaEliminada = categoriasService.obtenerCategoriaPorId(categoriaId);
        categoriasService.eliminarCategoriaPorId(categoriaId);
        String mensaje = "Categoría '" + categoriaEliminada.getTitulo() + "' ha sido eliminada.";
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/buscar/{categoriaId}")
    public ResponseEntity<Categorias> obtenerCategoria(@PathVariable Integer categoriaId) {
        Categorias categoria = categoriasService.obtenerCategoriaPorId(categoriaId);
        return ResponseEntity.ok(categoria);
    }
}
