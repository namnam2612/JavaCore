package vn.com.claim.controller.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.service.UserService;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(@RequestParam(required = false) String username,
                                                 @RequestParam(required = false)LocalDate fromDate,
                                                 @RequestParam(required = false)LocalDate toDate,
                                                 @RequestParam(required = false) String phone,
                                                 Pageable pageable
                                                 ) {
        return ResponseEntity.ok(null);
    }
}
