package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.UserEntity;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
