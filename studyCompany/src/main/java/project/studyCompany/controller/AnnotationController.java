package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.AnnotationDTO;
import project.studyCompany.service.AnnotationService;

@RestController
@RequestMapping(value = "/annotationsControl")
public class AnnotationController {
    private final AnnotationService annotationService;

    public AnnotationController(AnnotationService annotationService) {
        this.annotationService = annotationService;
    }

    @GetMapping("/allAnnotations")
    public ResponseEntity<Page<AnnotationDTO>> getAllAnnotations(Pageable pageable){
        Page <AnnotationDTO> findAll = annotationService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @PostMapping("/addAnnotation")
    public ResponseEntity<AnnotationDTO> addAnnotation(@RequestBody AnnotationDTO annotationDTO){
        annotationDTO = annotationService.insert(annotationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(annotationDTO);
    }

    @PutMapping("/updateAnnotationInID = {id}")
    public ResponseEntity<AnnotationDTO> updateAnnotation(@PathVariable Long id, @RequestBody AnnotationDTO annotationDTO){
        return ResponseEntity.ok().body(annotationService.update(id, annotationDTO));
    }

    @DeleteMapping("/deleteAnnotationInID={id}")
    public ResponseEntity<AnnotationDTO> deletAnnotation(@PathVariable Long id){
        annotationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
