package com.kitapcidayi.kitapcidayi.service;

import com.kitapcidayi.kitapcidayi.model.Book;

import java.util.List;

public interface BooKService {
    List<Book> getAllBooks();

    List<Book> listFreeBooks();

    Book saveBook (Book book);

    Book getBookById (Long id);
    Book updateBook (Book book);

    void deleteBookById(Long id);

}
