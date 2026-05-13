package project.studyCompany.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.studyCompany.dto.UserDTO;
import project.studyCompany.entity.UserEntity;
import project.studyCompany.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable page){
        Page <UserEntity> users = userRepository.findAll(page);
        return users.map(UserDTO::new);
    }

    @Transactional
    public UserDTO insert (UserDTO user){
        UserEntity userEntity = new UserEntity();
        userEntity.setCpfUsuario(user.cpfUsuario());
        userEntity.setUserUsuario(user.userUsuario());
        userEntity.setTelefones(user.telefonesUsuario());
        userEntity.setEmailUsuario(user.emailUsuario());
        userEntity.setDataCriacaoContaUsuario(user.dataCriacaoContaUsuario());
        userEntity.setNomeUsuario(user.nomeUsuario());
        userEntity.setSenhaUsuario(user.senhaUsuario());
        userEntity.setStatusUsuario(user.statusUsuario());
        userEntity.setTipoUsuario(user.tipoUsuario());
        userEntity.setDataNascUsuario(user.dataNascUsuario());
        userEntity = userRepository.save(userEntity);
        return new UserDTO(userEntity);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO user){
        UserEntity userEntity = userRepository.getReferenceById(id);
        userEntity.setCpfUsuario(user.cpfUsuario());
        userEntity.setUserUsuario(user.userUsuario());
        userEntity.setTelefones(user.telefonesUsuario());
        userEntity.setEmailUsuario(user.emailUsuario());
        userEntity.setDataCriacaoContaUsuario(user.dataCriacaoContaUsuario());
        userEntity.setNomeUsuario(user.nomeUsuario());
        userEntity.setSenhaUsuario(user.senhaUsuario());
        userEntity.setStatusUsuario(user.statusUsuario());
        userEntity.setTipoUsuario(user.tipoUsuario());
        userEntity.setDataNascUsuario(user.dataNascUsuario());
        return new UserDTO(userRepository.save(userEntity));
    }

    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
