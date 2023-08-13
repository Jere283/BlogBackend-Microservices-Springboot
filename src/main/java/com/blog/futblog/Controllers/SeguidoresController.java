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
    public ResponseEntity<String> seguir(@PathVariable("seguidorId") Integer seguidorId, @PathVariable("seguidoId") Integer seguidoId) {
        Boolean existeSeguidor = seguidoresImpl.comporbar(seguidorId, seguidoId);
        String mensaje;

        if (Boolean.TRUE.equals(existeSeguidor)) {
            mensaje="Este usuario ya sigue a este otro usuario, no se puede volver a seguir";
        }else{
            Seguidores nuevoSeguidor = seguidoresImpl.Seguir(seguidorId, seguidoId);
            if (nuevoSeguidor != null) {
                mensaje = "Usuario seguido exitosamente";
            } else {
                mensaje = "No se pudo crear el objeto Seguidores";
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensaje);
            }
        }
        return ResponseEntity.ok(mensaje);
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
