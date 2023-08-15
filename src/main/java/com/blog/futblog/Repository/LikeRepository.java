package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blog.futblog.Models.Like;
import com.blog.futblog.Models.Publicacion;
import com.blog.futblog.Models.User;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    @Query("SELECT COUNT(l) FROM Like l WHERE l.likepublicacion.id = :publicacionId")
    Integer countLikesByPublicacionId(Integer publicacionId);

    Like findByLikeusuarioAndLikepublicacion(User likeusuario, Publicacion likepublicacion);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.likepublicacion.usuario.id = :usuarioId")
    Integer countLikesByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
