package project.studyCompany.dto;

import project.studyCompany.entity.ImageEntity;
import project.studyCompany.entity.UserEntity;

public record ImageDTO(Long idImagem, String enderecoImagem, UserEntity anotacao) {
    public ImageDTO(ImageEntity image){
        this(image.getIdImagem(), image.getEnderecoImagem(), image.getAnotacao());
    }
}
