package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.CommentEntity;

@Repository

public interface CommentRepository extends JpaRepository <CommentEntity, Long> {
}
