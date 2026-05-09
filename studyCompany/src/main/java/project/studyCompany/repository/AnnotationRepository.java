package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.AnnotationEntity;

@Repository

public interface AnnotationRepository extends JpaRepository <AnnotationEntity, Long> {
}
