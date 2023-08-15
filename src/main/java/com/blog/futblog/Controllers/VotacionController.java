package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.Services.Impl.VotacionImpl;

@RestController
@RequestMapping("api/votos")
public class VotacionController {
    @Autowired
    VotacionImpl votacionImpl;

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<Integer> countVotesForPregunta(@PathVariable Integer preguntaId) {
        Integer contador = votacionImpl.countVotesForPregunta(preguntaId);
        return new ResponseEntity<Integer>(contador, HttpStatus.OK);
    }

    @PostMapping("/votar/{preguntaId}/{usuarioId}")
    public ResponseEntity<String> guardarVoto(@PathVariable int preguntaId, @PathVariable int usuarioId) {
        Boolean existeVoto = votacionImpl.comporbar(preguntaId, usuarioId);
        String mensaje;

        if (Boolean.TRUE.equals(existeVoto)) {
            mensaje = "Este usuario ya dio voto en esta pregunta";
        } else {
            mensaje = votacionImpl.guardarVoto(preguntaId, usuarioId);
        }
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/quitarvoto/{preguntaId}/{usuarioId}")
    public ResponseEntity<String> eliminarVoto(@PathVariable int preguntaId, @PathVariable int usuarioId) {
        Boolean existeVoto = votacionImpl.comporbar(preguntaId, usuarioId);
        String mensaje;
        if (Boolean.TRUE.equals(existeVoto)) {
            mensaje = votacionImpl.quitarVoto(preguntaId, usuarioId);
        } else {
            mensaje = "No se puede quitar el voto porque no ha votado en la pregunta";
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/total/usuario/{usuarioId}")
    public ResponseEntity<Integer> contarLikesPorUsuarioId(@PathVariable Integer usuarioId) {
        Integer cantidadLikes = votacionImpl.countVotesByUsuarioId(usuarioId);
        return ResponseEntity.ok(cantidadLikes);
    }
    
}
