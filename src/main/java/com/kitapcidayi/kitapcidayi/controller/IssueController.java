package com.kitapcidayi.kitapcidayi.controller;

import com.kitapcidayi.kitapcidayi.model.Book;
import com.kitapcidayi.kitapcidayi.model.Issue;
import com.kitapcidayi.kitapcidayi.model.User;
import com.kitapcidayi.kitapcidayi.repository.UserRepository;
import com.kitapcidayi.kitapcidayi.service.BooKService;
import com.kitapcidayi.kitapcidayi.service.IssueService;
import com.kitapcidayi.kitapcidayi.utilities.UserPicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.text.ParseException;

@Controller
public class IssueController {

    private IssueService issueService;
    @Autowired
    private BooKService bookService;

    @Autowired
    private UserRepository userRepository;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public String listIssues(Model model) {
        model.addAttribute("issues", issueService.getAllIssues());
        return "issues";
    }

    @GetMapping("/issues/new/{id}")
    public String saveIssue(@PathVariable Long id, @ModelAttribute("issue") Issue issue, Book book, User user) throws ParseException {
        //Tarihleri ayarla
        Date today = new Date(System.currentTimeMillis());
        Date addedDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 15));
        Date expectedDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 7));

        //Kitabı seç, issue oluştur
        Book book1 = bookService.getBookById(id);
        Issue issue1 = new Issue(today, addedDate, expectedDate, false);
        issue1.setBook(book1);

        //Aktif kullanıcıyı seç, SQL sorgusu için gönder
        UserPicker userPicker = new UserPicker();
        User user1 = userRepository.findByEmail(userPicker.pickCurrentUser());
        issue1.setUser(user1);

        //Kaydet
        issueService.saveIssue(issue1);
        return "redirect:/user_details";
    }

    @GetMapping ("/user_details/release/{id}")
    public String deleteIssue (@PathVariable Long id) {
        issueService.deleteIssueById(id);
        return "redirect:/user_details";
    }

    @GetMapping ("/user_details/pickup/{id}")
    public String pickUpBook (@PathVariable Long id, @ModelAttribute("issue") Issue issue) {
        Issue existingIssue = issueService.getIssueById(id);
        existingIssue.setIssueid(id);
        existingIssue.setPickedUp(true);
        issueService.updateIssue((existingIssue));
        return "redirect:/user_details";
    }
}
