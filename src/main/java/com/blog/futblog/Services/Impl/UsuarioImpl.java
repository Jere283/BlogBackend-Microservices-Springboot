package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.RegistrarUsuarioDTO;
import com.blog.futblog.Models.User;
import com.blog.futblog.Repository.UsuarioRepository;
import com.blog.futblog.Services.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public User findUserById(Integer id) {
        User user = usuarioRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public User savUser(RegistrarUsuarioDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setNombre(dto.getNombre());
        user.setUsername(dto.getUsername());
        user.setClave(dto.getClave());

        usuarioRepository.save(user);

        return user;
    }

}
