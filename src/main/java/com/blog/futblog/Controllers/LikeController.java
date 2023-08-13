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

import com.blog.futblog.Services.Impl.LikeImpl;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    LikeImpl Likeimpl;

    @GetMapping("/publicacion/{publicacionId}")
    public ResponseEntity<Integer> countLikesForPublicacion(@PathVariable Integer publicacionId) {
        Integer contador = Likeimpl.countLikesForPublicacion(publicacionId);
        return new ResponseEntity<Integer>(contador, HttpStatus.OK);
    }

    @PostMapping("/darlike/{publicacionId}/{usuarioId}")
    public ResponseEntity<String> guardarLike(@PathVariable int publicacionId, @PathVariable int usuarioId) {
        Boolean existeLike = Likeimpl.comporbar(publicacionId, usuarioId);
        String mensaje;

        if (Boolean.TRUE.equals(existeLike)) {
            mensaje = "Este usuario ya dio like a esta publicacion";
        } else {
            mensaje = Likeimpl.guardarLike(publicacionId, usuarioId);
        }
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/unlike/{publicacionId}/{usuarioId}")
    public ResponseEntity<String> eliminarLikePorId(@PathVariable int publicacionId, @PathVariable int usuarioId) {
        Boolean existeLike = Likeimpl.comporbar(publicacionId, usuarioId);
        String mensaje;
        if (Boolean.TRUE.equals(existeLike)) {
            mensaje = Likeimpl.quitarLike(publicacionId, usuarioId);
        } else {
            mensaje = "No se puede quitar like porque no ha dado like a la publicacion";
        }
        return ResponseEntity.ok(mensaje);
    }

}
