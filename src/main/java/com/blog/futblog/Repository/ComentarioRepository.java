package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blog.futblog.Models.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Integer> {
    @Query("SELECT COUNT(c) FROM Comentario c JOIN c.publicacion p WHERE p.usuario.id = :usuarioId")
    Integer countComentariosByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
