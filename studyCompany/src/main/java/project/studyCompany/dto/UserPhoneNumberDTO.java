package project.studyCompany.dto;

import project.studyCompany.entity.UserEntity;
import project.studyCompany.entity.UserPhoneNumberEntity;

public record UserPhoneNumberDTO(Long idTelefone, String numTelefone, UserEntity usuario) {
    public UserPhoneNumberDTO(UserPhoneNumberEntity phone){
        this(phone.getIdTelefone(), phone.getNumTelefone(), phone.getUsuario());
    }
}
