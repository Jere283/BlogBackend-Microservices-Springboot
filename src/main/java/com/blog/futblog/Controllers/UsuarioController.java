package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.futblog.DTO.LoginDTO;
import com.blog.futblog.DTO.RegistrarUsuarioDTO;
import com.blog.futblog.Models.User;
import com.blog.futblog.Services.Impl.UsuarioImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioImpl usuarioImpl;

    @PostMapping("/register")
    public ResponseEntity<?> RegistrarUsuario(@RequestBody RegistrarUsuarioDTO dto) {

        String body = usuarioImpl.userExists(dto.getUsername(), dto.getEmail());

        if (body == null) {
            User user = usuarioImpl.savUser(dto);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

        return new ResponseEntity<String>(body, HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUsuario(@RequestBody LoginDTO dto) {
        User user = usuarioImpl.LoginUser(dto);

        if (user == null) {
            return new ResponseEntity<String>("El usuario o clave esta incorrecto", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

}
