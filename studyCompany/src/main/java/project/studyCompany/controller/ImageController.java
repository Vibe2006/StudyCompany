package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.ImageDTO;
import project.studyCompany.service.ImageService;

@RestController
@RequestMapping(value = "/imageControl")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("/allImages")
    public ResponseEntity<Page<ImageDTO>> getAllImages(Pageable pageable){
        Page<ImageDTO> findALl = imageService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findALl);
    }

    @PostMapping("/addImage")
    public ResponseEntity<ImageDTO> addImage(@RequestBody ImageDTO imageDTO){
        imageDTO = imageService.insert(imageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageDTO);
    }

    @PutMapping("/updateImageInID={id}")
    public ResponseEntity<ImageDTO> updateImage(@RequestBody ImageDTO imageDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(imageService.update(imageDTO, id));
    }

    @DeleteMapping("/deleteImageInID={id}")
    public ResponseEntity<ImageDTO> deleteImage(@PathVariable Long id){
        imageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
