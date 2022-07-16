package com.kitapcidayi.kitapcidayi.controller;

import com.kitapcidayi.kitapcidayi.model.Book;
import com.kitapcidayi.kitapcidayi.service.BooKService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {

    private BooKService bookService;

    public BookController(BooKService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String addBooks(Model model) {
            Book book = new Book();
            model.addAttribute("book", book);
            return "add_book";
    }

    @PostMapping("/books")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_book";
        } else {
            bookService.saveBook(book);
            return "redirect:/books?success";
        }
    }

    @GetMapping("/books/edit/{id}")
    public  String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "update_book";
    }

    @PostMapping("/books/{id}")
    public String updateBook (@PathVariable Long id, @Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return editBook(id, model.addAttribute("book", bookService.getBookById(id)));
        }
        else {
            Book existingBook = bookService.getBookById(id);
            //ilgili öğrenciyi databaseden al
            existingBook.setBID(id);
            existingBook.setBookName(book.getBookName());
            existingBook.setCategory(book.getCategory());
            existingBook.setIsbn(book.getIsbn());
            //database kaydet
            bookService.updateBook((existingBook));
            return "redirect:/books";
        }
    }

    @GetMapping ("/books/{id}")
    public String deleteBook (@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

}
