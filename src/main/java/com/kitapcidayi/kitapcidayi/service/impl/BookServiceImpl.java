package com.kitapcidayi.kitapcidayi.service.impl;

import com.kitapcidayi.kitapcidayi.model.Book;
import com.kitapcidayi.kitapcidayi.repository.BookRepository;
import com.kitapcidayi.kitapcidayi.service.BooKService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BooKService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> listFreeBooks() {
        return bookRepository.listFreeBooks();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
