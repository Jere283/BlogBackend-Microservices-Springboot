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

import com.blog.futblog.Models.Seguidores;
import com.blog.futblog.Services.Impl.SeguidoresImpl;

@RestController
@RequestMapping("/api/seguidores")
public class SeguidoresController {
    @Autowired
    SeguidoresImpl seguidoresImpl;

    @GetMapping("/{usuarioId}/seguidores")
    public ResponseEntity<Integer> contarSeguidores(@PathVariable("usuarioId") Integer seguidoId) {
        int cantidadSeguidores = seguidoresImpl.contarSeguidores(seguidoId);
        return ResponseEntity.ok(cantidadSeguidores);
    }

    @GetMapping("/{usuarioId}/seguidos")
    public ResponseEntity<Integer> contarSeguidos(@PathVariable("usuarioId") Integer seguidorId) {
        int cantidadSeguidos = seguidoresImpl.contarSeguidos(seguidorId);
        return ResponseEntity.ok(cantidadSeguidos);
    }
    
    @PostMapping("/{seguidorId}/seguir/{seguidoId}")
    public ResponseEntity<Seguidores> seguir(@PathVariable("seguidorId") Integer seguidorId, @PathVariable("seguidoId") Integer seguidoId) {
        Seguidores seguidores = seguidoresImpl.Seguir(seguidorId, seguidoId);
        return ResponseEntity.ok(seguidores);
    }

    @GetMapping("/comprobar-seguimiento/{seguidorId}/{seguidoId}")
    public ResponseEntity<String> comprobarSeguimiento(
        @PathVariable int seguidorId,
        @PathVariable int seguidoId) {
        String mensaje= seguidoresImpl.comporbarSeguimiento(seguidorId, seguidoId);    
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/eliminar-seguimiento/{seguidorId}/{seguidoId}")
    public ResponseEntity<String> eliminarSeguimiento(
        @PathVariable int seguidorId,
        @PathVariable int seguidoId) {
        String mensaje=seguidoresImpl.eliminarSeguimiento(seguidorId, seguidoId);
        return ResponseEntity.ok(mensaje);
    }
}
