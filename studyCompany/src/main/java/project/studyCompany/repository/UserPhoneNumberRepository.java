package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.UserPhoneNumberEntity;

@Repository

public interface UserPhoneNumberRepository extends JpaRepository<UserPhoneNumberEntity, Long> {
}
