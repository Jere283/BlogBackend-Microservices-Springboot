package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Services.EncuestasService;
import com.blog.futblog.Services.PublicacionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {
    @Autowired
    private EncuestasService encuestasService;

    /*@PostMapping("/crear")
    public ResponseEntity<?> crearEncuesta(@RequestBody EncuestasDTO encuestaDTO) {
        Encuestas encuesta = encuestasService.crearEncuesta(encuestaDTO);
        return ResponseEntity.ok().body(encuesta);
    }*/

    @PostMapping("/crear")
    public ResponseEntity<String> crearEncuesta(@RequestBody EncuestasDTO encuestaDTO) {
        //Encuestas encuesta = encuestasService.crearEncuesta(encuestaDTO);
        String mensaje = "El título de la encuesta creada es: " + encuestaDTO.getTitulo();
        return ResponseEntity.ok().body(mensaje);
    }
    
}
