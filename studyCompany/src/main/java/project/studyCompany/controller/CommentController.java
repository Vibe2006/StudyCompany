package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.CommentDTO;
import project.studyCompany.service.CommentService;

@RestController
@RequestMapping(value = "/commentsControl")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/allComments")
    public ResponseEntity<Page<CommentDTO>> getAllComments(Pageable pageable){
        Page <CommentDTO> findAll = commentService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @PostMapping("/addComment")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO){
        commentDTO = commentService.insert(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDTO);
    }

    @PutMapping("/updateCommentInID={id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok().body(commentService.update(commentDTO, id));
    }

    @DeleteMapping("/deleteCommentInID={id}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable Long id){
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
