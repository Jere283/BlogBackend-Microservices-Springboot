package com.blog.futblog.Services;

import com.blog.futblog.DTO.LoginDTO;
import com.blog.futblog.DTO.RegistrarUsuarioDTO;
import com.blog.futblog.Models.User;

public interface UsuarioService {

    public User findUserById(Integer id);

    public User savUser(RegistrarUsuarioDTO dto);

    public String userExists(String username, String email);

    public User findUserByUserName(String username);

    public User findUserByEmail(String email);

    public User LoginUser(LoginDTO dto);
}
