package project.studyCompany.dto;

import project.studyCompany.entity.ReportEntity;
import project.studyCompany.entity.UserEntity;

import java.time.LocalDateTime;

public record ReportDTO(Long idDenuncia, String motivoDenuncia, String statusDenuncia, String alvoUserDenuncia, LocalDateTime dataCriacaoDenuncia,
                        UserEntity usuario) {
    public ReportDTO(ReportEntity report){
        this(report.getIdDenuncia(), report.getMotivoDenuncia(), report.getStatusDenuncia(), report.getAlvoUserDenuncia(),
                report.getDataCriacaoDenuncia(), report.getUsuario());
    }
}
