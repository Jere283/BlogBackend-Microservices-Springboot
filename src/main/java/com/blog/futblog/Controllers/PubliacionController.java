package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.PublicacionDTO;
import com.blog.futblog.Services.Impl.PublicacionImpl;

@RestController
@RequestMapping("/api/publicacion")
public class PubliacionController {
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
}
