package com.blog.futblog.Repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.futblog.Models.User;

public interface UsuarioRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
