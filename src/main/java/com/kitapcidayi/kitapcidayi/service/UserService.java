package com.kitapcidayi.kitapcidayi.service;

import com.kitapcidayi.kitapcidayi.model.Book;
import com.kitapcidayi.kitapcidayi.model.User;
import com.kitapcidayi.kitapcidayi.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save (UserRegistrationDto registrationDto);

    List<Book> listCurrentUserBooks(User id);

    List<User> getAllUsers();

    User getUserById (Long id);

    User updateUser (User user);

    void deleteUserById(Long id);

}
