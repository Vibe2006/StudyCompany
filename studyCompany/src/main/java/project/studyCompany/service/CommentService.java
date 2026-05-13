package project.studyCompany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.studyCompany.dto.CommentDTO;
import project.studyCompany.entity.CommentEntity;
import project.studyCompany.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Transactional(readOnly = true)
    public Page<CommentDTO> findAllPaged(Pageable pageable){
        Page<CommentEntity> comments = commentRepository.findAll(pageable);
        return comments.map(CommentDTO::new);
    }

    @Transactional
    public CommentDTO insert (CommentDTO comment){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setAnotacao(comment.anotacao());
        commentEntity.setDataCriacaoContaUsuario(comment.dataCriacaoContaUsuario());
        commentEntity.setUsuario(comment.usuario());
        commentEntity.setConteudoComentario(comment.conteudoComentario());
        commentEntity.setStatusComentario(comment.statusComentario());
        commentEntity = commentRepository.save(commentEntity);
        return new CommentDTO(commentEntity);
    }

    @Transactional
    public CommentDTO update (CommentDTO comment, Long id){
        CommentEntity commentEntity = commentRepository.getReferenceById(id);
        commentEntity.setAnotacao(comment.anotacao());
        commentEntity.setDataCriacaoContaUsuario(comment.dataCriacaoContaUsuario());
        commentEntity.setUsuario(comment.usuario());
        commentEntity.setConteudoComentario(comment.conteudoComentario());
        commentEntity.setStatusComentario(comment.statusComentario());
        return new CommentDTO(commentRepository.save(commentEntity));
    }

    @Transactional
    public void delete(Long id){
        if(!commentRepository.existsById(id)){
            throw new RuntimeException("Comment not found");
        }

        commentRepository.deleteById(id);
    }
}
