package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.blog.futblog.Models.Seguidores;
import com.blog.futblog.Models.User;

public interface SeguidoresRepository extends CrudRepository<Seguidores, Integer> {
    @Query("SELECT COUNT(s) FROM Seguidores s WHERE s.seguidousuario.id = :seguidoId")
    Integer countSeguidores(Integer seguidoId);

    @Query("SELECT COUNT(s) FROM Seguidores s WHERE s.seguidorusuario.id = :seguidorId")
    Integer countSeguidos(Integer seguidorId);

    Seguidores findBySeguidorusuarioAndSeguidousuario(User seguidor, User seguido);
}
