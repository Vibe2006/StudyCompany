package project.studyCompany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.studyCompany.dto.ReportDTO;
import project.studyCompany.entity.ReportEntity;
import project.studyCompany.repository.ReportRepository;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    @Transactional(readOnly = true)
    public Page<ReportDTO> findAllPaged(Pageable pageable){
        Page <ReportEntity> reports = reportRepository.findAll(pageable);
        return reports.map(ReportDTO::new);
    }

    @Transactional
    public ReportDTO insert (ReportDTO report){
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setUsuario(report.usuario());
        reportEntity.setAlvoUserDenuncia(report.alvoUserDenuncia());
        reportEntity.setStatusDenuncia(report.statusDenuncia());
        reportEntity.setMotivoDenuncia(report.motivoDenuncia());
        reportEntity.setDataCriacaoDenuncia(report.dataCriacaoDenuncia());
        reportEntity = reportRepository.save(reportEntity);
        return new ReportDTO(reportEntity);
    }

    @Transactional
    public ReportDTO update(ReportDTO report, Long id){
        ReportEntity reportEntity = reportRepository.getReferenceById(id);
        reportEntity.setUsuario(report.usuario());
        reportEntity.setAlvoUserDenuncia(report.alvoUserDenuncia());
        reportEntity.setStatusDenuncia(report.statusDenuncia());
        reportEntity.setMotivoDenuncia(report.motivoDenuncia());
        reportEntity.setDataCriacaoDenuncia(report.dataCriacaoDenuncia());
        return new ReportDTO(reportRepository.save(reportEntity));
    }

    @Transactional
    public void delete(Long id){
        if(!reportRepository.existsById(id)){
            throw new RuntimeException("Report not found");
        }
        reportRepository.deleteById(id);
    }
}
