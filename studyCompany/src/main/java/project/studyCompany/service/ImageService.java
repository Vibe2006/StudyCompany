package project.studyCompany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.studyCompany.dto.ImageDTO;
import project.studyCompany.entity.ImageEntity;
import project.studyCompany.repository.ImageRepository;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService (ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Transactional(readOnly = true)
    public Page<ImageDTO> findAllPaged(Pageable pageable){
        Page<ImageEntity> images = imageRepository.findAll(pageable);
        return images.map(ImageDTO::new);
    }

    @Transactional
    public ImageDTO insert (ImageDTO image){
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setAnotacao(image.anotacao());
        imageEntity.setEnderecoImagem(image.enderecoImagem());
        imageEntity = imageRepository.save(imageEntity);
        return new ImageDTO(imageEntity);
    }

    @Transactional
    public ImageDTO update (ImageDTO imageDTO, Long id){
        ImageEntity imageEntity = imageRepository.getReferenceById(id);
        imageEntity.setAnotacao(imageDTO.anotacao());
        imageEntity.setEnderecoImagem(imageDTO.enderecoImagem());
        return new ImageDTO(imageRepository.save(imageEntity));
    }

    @Transactional
    public void delete (Long id){
        if(!imageRepository.existsById(id)){
            throw new RuntimeException("Image not found");
        }
        imageRepository.deleteById(id);
    }
}
