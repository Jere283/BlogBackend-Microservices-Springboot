package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.futblog.Models.User;

public interface UsuarioRepository extends JpaRepository<User, Integer> {

}
