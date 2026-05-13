package project.studyCompany.dto;

import project.studyCompany.entity.CommentEntity;
import project.studyCompany.entity.UserEntity;

import java.time.LocalDateTime;

public record CommentDTO(Long idComentario, String conteudoComentario, String statusComentario, LocalDateTime dataCriacaoContaUsuario,
                         UserEntity usuario, UserEntity anotacao) {

    public CommentDTO(CommentEntity comment) {
        this(comment.getIdComentario(), comment.getConteudoComentario(), comment.getStatusComentario(), comment.getDataCriacaoContaUsuario(),
                comment.getUsuario(), comment.getAnotacao());
    }
}
