package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.AdminEntity;

@Repository

public interface AdminRepository extends JpaRepository <AdminEntity, Long> {
}
