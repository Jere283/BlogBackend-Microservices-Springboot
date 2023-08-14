package com.blog.futblog.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.futblog.DTO.LoginDTO;
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

    @Override
    public String userExists(String username, String email) {

        User byEmail = usuarioRepository.findUserByEmail(email);
        User byUname = usuarioRepository.findUserByUsername(username);

        if (byEmail != null) {
            return "El correo ya existe";
        }

        if (byUname != null) {
            return "El nombre de usuario ya existe";
        }

        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return usuarioRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUserName(String username) {
        return usuarioRepository.findUserByUsername(username);
    }

    @Override
    public User LoginUser(LoginDTO dto) {
        User user = findUserByEmail(dto.getUsernameOrEmail());

        if (user == null) {
            user = findUserByUserName(dto.getUsernameOrEmail());
        }

        if (user == null) {
            return null;
        } else if (user.getClave().equals(dto.getClave())) {
            return user;
        }
        return null;

    }

}
