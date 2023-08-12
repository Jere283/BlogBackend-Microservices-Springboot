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

import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Services.Impl.PublicacionImpl;

@RestController
@RequestMapping("/api/publicacion")
public class PublicacionController {
    @Autowired
    PublicacionImpl publicacionImpl;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPubliacion(@RequestBody PublicacionDTO dto) {
        if (dto.getContenido() == null) {
            return new ResponseEntity<String>("La publicacion es nula pero se almaceno", HttpStatus.NOT_ACCEPTABLE);
        }

        publicacionImpl.savePublicacion(dto);
        return new ResponseEntity<String>("La publicacion fue guardada correctamente", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Publicacion>> ObtenerTodasLasPublicaciones() {
        List<Publicacion> publicaciones = publicacionImpl.getAllPublicaciones();

        return new ResponseEntity<List<Publicacion>>(publicaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ObtenerPublicacionPorId(@PathVariable int id) {
        Publicacion publicacion = publicacionImpl.getPublicacionById(id);

        if (publicacion == null) {
            return new ResponseEntity<String>("La publicacion no existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Publicacion>(publicacion, HttpStatus.OK);

    }
}
