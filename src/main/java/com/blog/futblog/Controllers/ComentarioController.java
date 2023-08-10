package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.ComentarioDTO;
import com.blog.futblog.Services.Impl.ComentarioImpl;

@RestController
@RequestMapping("api/comentario")
public class ComentarioController {

    @Autowired
    ComentarioImpl comentarioImpl;

    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentarioDTO dto) {
        if (dto.getContenido() == null) {
            return new ResponseEntity<String>("El comentario es nulo pero se almaceno", HttpStatus.NOT_ACCEPTABLE);
        }

        comentarioImpl.saveComentario(dto);
        return new ResponseEntity<String>("El comentario fue guardado correctamente", HttpStatus.OK);
    }
}
