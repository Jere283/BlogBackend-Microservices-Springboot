package com.blog.futblog.Services;

import com.blog.futblog.DTO.RegistrarUsuarioDTO;
import com.blog.futblog.Models.User;

public interface UsuarioService {

    public User findUserById(Integer id);

    public User savUser(RegistrarUsuarioDTO dto);
}
