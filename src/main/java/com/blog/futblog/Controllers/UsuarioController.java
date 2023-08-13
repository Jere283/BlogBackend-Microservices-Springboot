package com.blog.futblog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/save")
    public ResponseEntity<User> RegistrarUsuario(@RequestBody RegistrarUsuarioDTO dto) {

        User user = usuarioImpl.savUser(dto);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
