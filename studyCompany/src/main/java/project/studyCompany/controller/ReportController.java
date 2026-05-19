package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.ReportDTO;
import project.studyCompany.service.ReportService;

@RestController
@RequestMapping(value = "/reportControl")
public class ReportController {
    private final ReportService reportService;

    public  ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/allReports")
    public ResponseEntity <Page<ReportDTO>> getAllReports(Pageable pageable){
        Page<ReportDTO> findAll = reportService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @PostMapping("/addReport")
    public ResponseEntity<ReportDTO> addImage(@RequestBody ReportDTO reportDTO){
        reportDTO = reportService.insert(reportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportDTO);
    }

    @PutMapping("/updateReportInID={id}")
    public ResponseEntity <ReportDTO> updateReport(@PathVariable Long id, @RequestBody ReportDTO reportDTO){
        return ResponseEntity.ok().body(reportService.update(reportDTO, id));
    }

    @DeleteMapping("/deleteReportInID={id}")
    public ResponseEntity<ReportDTO> deleteReport(@PathVariable Long id){
        reportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
