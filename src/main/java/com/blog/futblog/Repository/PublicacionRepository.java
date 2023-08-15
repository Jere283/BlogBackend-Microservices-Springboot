package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.blog.futblog.Models.Publicacion;

public interface PublicacionRepository extends CrudRepository<Publicacion, Integer> {
    @Query("SELECT COUNT(p) FROM Publicacion p WHERE p.usuario.id = :usuarioId")
    Integer countPublicacionesByUsuarioId(Integer usuarioId);

}
