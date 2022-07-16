package com.kitapcidayi.kitapcidayi.repository;

import com.kitapcidayi.kitapcidayi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BookRepository extends JpaRepository <Book, Long> {

    @Query("FROM Book b LEFT JOIN Issue i ON b = i.book WHERE i.book IS NULL")
    List<Book> listFreeBooks();

}
