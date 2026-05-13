package project.studyCompany.dto;

import project.studyCompany.entity.AnnotationEntity;
import project.studyCompany.entity.UserEntity;

import java.time.LocalDateTime;

public record AnnotationDTO(Long idAnotacao, String tituloAnotacao, String conteudoAnotacao,
                            String statusAnotacao, LocalDateTime dataCriacaoAnotacao, UserEntity usuario) {

    public AnnotationDTO(AnnotationEntity annotation){
        this(annotation.getIdAnotacao(), annotation.getTituloAnotacao(), annotation.getConteudoAnotacao(), annotation.getStatusAnotacao(),
                annotation.getDataCriacaoAnotacao(), annotation.getUsuario());
    }
}
