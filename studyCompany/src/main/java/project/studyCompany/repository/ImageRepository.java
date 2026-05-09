package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.ImageEntity;

@Repository

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
