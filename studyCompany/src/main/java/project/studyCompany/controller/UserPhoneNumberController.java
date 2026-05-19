package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.UserPhoneNumberDTO;
import project.studyCompany.service.UserPhoneNumberService;

@RestController
@RequestMapping(value = "/userPhoneNumberControl")
public class UserPhoneNumberController {
    private final UserPhoneNumberService userPhoneNumberService;

    public UserPhoneNumberController(UserPhoneNumberService userPhoneNumberService) {
        this.userPhoneNumberService = userPhoneNumberService;
    }

    @GetMapping("/allUserPhoneNumber")
    public ResponseEntity<Page<UserPhoneNumberDTO>> getAllUserPhoneNumbers(Pageable pageable){
        Page<UserPhoneNumberDTO> findAll = userPhoneNumberService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @PostMapping("/addUserPhoneNumber")
    public ResponseEntity <UserPhoneNumberDTO> addUserPhoneNumber(@RequestBody UserPhoneNumberDTO userPhoneNumberDTO){
        userPhoneNumberDTO = userPhoneNumberService.insert(userPhoneNumberDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userPhoneNumberDTO);
    }

    @PutMapping("/updateUserPhoneNumberInID={id}")
    public ResponseEntity <UserPhoneNumberDTO> updateUserPhoneNumber(@RequestBody UserPhoneNumberDTO userPhoneNumberDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(userPhoneNumberService.update(userPhoneNumberDTO,id));
    }

    @DeleteMapping("/deleteUserPhoneNumberInID={id}")
    public ResponseEntity <UserPhoneNumberDTO> deleteUserPhoneNumber(@PathVariable Long id){
        userPhoneNumberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
