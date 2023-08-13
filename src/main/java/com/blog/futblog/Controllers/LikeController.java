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

import com.blog.futblog.Models.Like;
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
    public ResponseEntity<Like> guardarLike(@PathVariable int publicacionId, @PathVariable int usuarioId) {
        Like like = Likeimpl.guardarLike(publicacionId, usuarioId);

        return new ResponseEntity<Like>(like, HttpStatus.OK);
    }

    @DeleteMapping("/unlike/{likeId}")
    public ResponseEntity<String> eliminarLikePorId(@PathVariable int likeId) {
        Likeimpl.eliminarLikePorId(likeId);
        return new ResponseEntity<String>("El Like se ha quitado correctamente", HttpStatus.OK);
    }

}
