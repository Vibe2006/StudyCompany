package project.studyCompany.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.studyCompany.dto.UserDTO;
import project.studyCompany.service.UserService;

@RestController
@RequestMapping(value = "/userAdmin")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("allUsers")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable){
        Page <UserDTO> findAll = userService.findAllPaged(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<UserDTO> insertAdmin(@RequestBody UserDTO userDTO){
        userDTO = userService.insert(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @PutMapping("/updateInfoAdminID={id}")
    public ResponseEntity<UserDTO> updateInfoAdmin(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(userService.update(id, userDTO));
    }

    @DeleteMapping("/deleteAdminInID={id}")
    public ResponseEntity<UserDTO> deleteAdmin(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
