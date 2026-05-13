package project.studyCompany.dto;

import project.studyCompany.entity.UserEntity;
import project.studyCompany.entity.UserPhoneNumberEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record UserDTO(Long idUsuario, String nomeUsuario, String cpfUsuario, LocalDate dataNascUsuario, LocalDateTime dataCriacaoContaUsuario,
                      String emailUsuario, String senhaUsuario, String userUsuario, String statusUsuario, String tipoUsuario,
                      List<UserPhoneNumberEntity> telefonesUsuario) {

    public UserDTO(UserEntity user){
        this(user.getIdUsuario(), user.getNomeUsuario(), user.getCpfUsuario(), user.getDataNascUsuario(), user.getDataCriacaoContaUsuario(), user.getEmailUsuario(),
                user.getSenhaUsuario(), user.getUserUsuario(), user.getStatusUsuario(), user.getTipoUsuario(), user.getTelefones());
    }
}
