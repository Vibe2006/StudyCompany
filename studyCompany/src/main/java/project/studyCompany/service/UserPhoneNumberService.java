package project.studyCompany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.studyCompany.dto.UserPhoneNumberDTO;
import project.studyCompany.entity.UserPhoneNumberEntity;
import project.studyCompany.repository.UserPhoneNumberRepository;

@Service
public class UserPhoneNumberService {
    private final UserPhoneNumberRepository userPhoneNumberRepository;

    public  UserPhoneNumberService(UserPhoneNumberRepository userPhoneNumberRepository) {
        this.userPhoneNumberRepository = userPhoneNumberRepository;
    }

    @Transactional(readOnly = true)
    public Page<UserPhoneNumberDTO> findAllPaged(Pageable pageable){
        Page< UserPhoneNumberEntity> userPhoneNumbers = userPhoneNumberRepository.findAll(pageable);
        return userPhoneNumbers.map(UserPhoneNumberDTO::new);
    }

    @Transactional
    public UserPhoneNumberDTO insert(UserPhoneNumberDTO userPhone){
        UserPhoneNumberEntity userPhoneEntity = new UserPhoneNumberEntity();
        userPhoneEntity.setUsuario(userPhone.usuario());
        userPhoneEntity.setNumTelefone(userPhone.numTelefone());
        userPhoneEntity =  userPhoneNumberRepository.save(userPhoneEntity);
        return new UserPhoneNumberDTO(userPhoneEntity);
    }

    @Transactional
    public UserPhoneNumberDTO update(UserPhoneNumberDTO userPhone, Long id){
        UserPhoneNumberEntity userPhoneEntity = userPhoneNumberRepository.getReferenceById(id);
        userPhoneEntity.setUsuario(userPhone.usuario());
        userPhoneEntity.setNumTelefone(userPhone.numTelefone());
        return new UserPhoneNumberDTO(userPhoneNumberRepository.save(userPhoneEntity));
    }

    @Transactional
    public void delete (Long id){
        if(!userPhoneNumberRepository.existsById(id)){
            throw new RuntimeException("User Phone Number Not Found");
        }
        userPhoneNumberRepository.deleteById(id);
    }
}
