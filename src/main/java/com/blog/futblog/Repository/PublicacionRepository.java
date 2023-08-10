package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.futblog.Models.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

}
