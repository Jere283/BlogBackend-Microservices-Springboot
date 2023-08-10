package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.futblog.Models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
