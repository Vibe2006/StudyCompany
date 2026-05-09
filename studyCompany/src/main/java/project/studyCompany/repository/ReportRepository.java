package project.studyCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.studyCompany.entity.ReportEntity;

@Repository

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
