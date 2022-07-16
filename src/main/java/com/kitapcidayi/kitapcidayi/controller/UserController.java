package com.kitapcidayi.kitapcidayi.controller;

import com.kitapcidayi.kitapcidayi.model.User;
import com.kitapcidayi.kitapcidayi.repository.IssueRepository;
import com.kitapcidayi.kitapcidayi.repository.UserRepository;
import com.kitapcidayi.kitapcidayi.service.IssueService;
import com.kitapcidayi.kitapcidayi.service.UserService;
import com.kitapcidayi.kitapcidayi.utilities.PickUpControl;
import com.kitapcidayi.kitapcidayi.utilities.UserPicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping ("/users/{id}")
    public String deleteUser (@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public  String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "update_user";
    }

    @PostMapping("/users/{id}")
    public String updateUser (@PathVariable Long id, @Valid  @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return editUser(id, model.addAttribute("user", userService.getUserById(id)));
        }
        else {
            User existingUser = userService.getUserById(id);
            existingUser.setId(id);
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.updateUser((existingUser));
            return "redirect:/users";
        }
    }

    @GetMapping("/user_details")
    public String listUserBooks (Model model) throws SQLException {

        //Pickup Control
        PickUpControl pickUpControl = new PickUpControl();
        issueService.deleteNotPickedUpIssues(pickUpControl.today());

        //Thymeleaf tarih için
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("standardDate", new Date());

        //Aktif kullanıcıyı seç, SQL sorgusu için gönder
        UserPicker userPicker = new UserPicker();
        User user1 = userRepository.findByEmail(userPicker.pickCurrentUser());
        model.addAttribute("books", userService.listCurrentUserBooks(user1));
        return "user_details";
    }

}
