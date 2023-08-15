package com.blog.futblog.Services;

public interface VotacionService {
    public int countVotesForPregunta(int preguntaId);

    public String guardarVoto(int preguntaId, int usuarioId);

    public void eliminarVotoById(int votoId);

    public String quitarVoto(int preguntaId, int usuarioId);

    public Boolean comporbar(int preguntaId, int usuarioId);

    Integer countVotesByUsuarioId(Integer usuarioId);
}
