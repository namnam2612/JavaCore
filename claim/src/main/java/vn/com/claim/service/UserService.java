package vn.com.claim.service;

import vn.com.claim.dto.UserDTO;
import vn.com.claim.entity.UserEntity;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface UserService {

    List<UserDTO> getUsers(String username,
                           LocalDate fromDate,
                           LocalDate toDate,
                           String phone,
                           Pageable pageable
    );
}
