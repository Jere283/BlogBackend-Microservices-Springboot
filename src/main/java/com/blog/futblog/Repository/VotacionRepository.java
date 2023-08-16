package com.blog.futblog.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blog.futblog.Models.Preguntas;
import com.blog.futblog.Models.User;
import com.blog.futblog.Models.Votacion;

public interface VotacionRepository extends CrudRepository<Votacion, Integer> {
    @Query("SELECT COUNT(v) FROM Votacion v WHERE v.votacionpregunta.id = :preguntaId")
    Integer countLikesByPreguntaId(Integer preguntaId);

    Votacion findByVotacionusuarioAndVotacionpregunta(User votacionusuario, Preguntas votacionpregunta);

    @Query("SELECT COUNT(v) FROM Votacion v " +
            "JOIN v.votacionpregunta pregunta " +
            "JOIN pregunta.preguntaEncuesta encuesta " +
            "WHERE encuesta.encuestausuario.id = :usuarioId")
    Integer countVotosByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
