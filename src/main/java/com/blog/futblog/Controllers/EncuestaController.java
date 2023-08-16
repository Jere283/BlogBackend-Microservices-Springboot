package com.blog.futblog.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.EncuestasDTO;
import com.blog.futblog.Models.Encuestas;
import com.blog.futblog.Services.EncuestasService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {
    @Autowired
    private EncuestasService encuestasService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearEncuesta(@RequestBody EncuestasDTO encuestaDTO) {
        Encuestas encuesta = encuestasService.crearEncuesta(encuestaDTO);
        return ResponseEntity.ok().body(encuesta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEncuesta(@PathVariable Integer id) {
        try {
            String mensaje = encuestasService.eliminarEncuesta(id);
            return ResponseEntity.ok().body(mensaje);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Encuestas>> ObtenerEncuestas() {
        List<Encuestas> encuestas = encuestasService.getAllEncuetsas();

        return new ResponseEntity<List<Encuestas>>(encuestas, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> ObtenerEncuestaPorId(@PathVariable int id) {
        Encuestas encuestas = encuestasService.getEncuestasById(id);

        if (encuestas == null) {
            return new ResponseEntity<String>("La Encuesta no existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Encuestas>(encuestas, HttpStatus.OK);

    }

    /*
     * @PostMapping("/crear")
     * public ResponseEntity<String> crearEncuesta(@RequestBody EncuestasDTO
     * encuestaDTO) {
     * // Encuestas encuesta = encuestasService.crearEncuesta(encuestaDTO);
     * String mensaje = encuestaDTO.getTitulo();
     * return new ResponseEntity<String>(mensaje, HttpStatus.OK);
     * }
     */

}
