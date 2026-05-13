package project.studyCompany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.studyCompany.dto.AnnotationDTO;
import project.studyCompany.entity.AnnotationEntity;
import project.studyCompany.repository.AnnotationRepository;

@Service
public class AnnotationService {
    private final AnnotationRepository annotationRepository;

    public AnnotationService(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    @Transactional(readOnly = true)
    public Page<AnnotationDTO> findAllPaged(Pageable page){
        Page <AnnotationEntity> annotations = annotationRepository.findAll(page);
        return annotations.map(AnnotationDTO::new);
    }

    @Transactional
    public AnnotationDTO insert(AnnotationDTO annotation){
        AnnotationEntity annotationEntity = new AnnotationEntity();
        annotationEntity.setUsuario(annotation.usuario());
        annotationEntity.setConteudoAnotacao(annotation.conteudoAnotacao());
        annotationEntity.setTituloAnotacao(annotation.tituloAnotacao());
        annotationEntity.setStatusAnotacao(annotation.statusAnotacao());
        annotationEntity.setDataCriacaoAnotacao(annotation.dataCriacaoAnotacao());
        annotationEntity = annotationRepository.save(annotationEntity);
        return new AnnotationDTO(annotationEntity);
    }

    @Transactional
    public AnnotationDTO update(Long id, AnnotationDTO annotation){
        AnnotationEntity annotationEntity = annotationRepository.getReferenceById(id);
        annotationEntity.setUsuario(annotation.usuario());
        annotationEntity.setConteudoAnotacao(annotation.conteudoAnotacao());
        annotationEntity.setTituloAnotacao(annotation.tituloAnotacao());
        annotationEntity.setStatusAnotacao(annotation.statusAnotacao());
        annotationEntity.setDataCriacaoAnotacao(annotation.dataCriacaoAnotacao());
        return new AnnotationDTO(annotationRepository.save(annotationEntity));
    }

    @Transactional
    public void delete(Long id){
        if(!annotationRepository.existsById(id)){
            throw new RuntimeException("Annotation not found");
        }
        annotationRepository.deleteById(id);
    }
}
