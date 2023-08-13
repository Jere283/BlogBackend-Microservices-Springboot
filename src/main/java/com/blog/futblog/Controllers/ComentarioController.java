package com.blog.futblog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Models.Comentario;
import com.blog.futblog.Services.Impl.ComentarioImpl;

@RestController
@RequestMapping("api/comentario")
public class ComentarioController {

    @Autowired
    ComentarioImpl comentarioImpl;

    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentarioDTO dto) {
        if (dto.getContenido() == null) {
            return new ResponseEntity<String>("El comentario es nulo", HttpStatus.NOT_ACCEPTABLE);
        }

        comentarioImpl.saveComentario(dto);
        return new ResponseEntity<String>("El comentario fue guardado correctamente", HttpStatus.OK);
    }

    @PostMapping("/crear/id/{publicacionId}")
    public ResponseEntity<String> guardarComentario(
            @PathVariable int publicacionId,
            @RequestBody ComentarioDTO comentarioDTO) {
        comentarioImpl.guarardComentarios(publicacionId, comentarioDTO);
        return new ResponseEntity<>("Comentario guardado exitosamente.", HttpStatus.CREATED);
    }

    @GetMapping("/publicacion/{id}")
    public ResponseEntity<?> obtenerComentariosPorPublicacion(@PathVariable Integer id) {
        List<Comentario> comentarios = comentarioImpl.getComentariosByPublicacion(id);

        if (comentarios.isEmpty()) {
            return new ResponseEntity<String>("No hay comentarios en esta publicacion", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<List<Comentario>>(comentarios, HttpStatus.OK);
    }
}
