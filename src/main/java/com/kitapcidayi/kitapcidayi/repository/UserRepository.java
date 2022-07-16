package com.kitapcidayi.kitapcidayi.repository;

import com.kitapcidayi.kitapcidayi.model.Book;
import com.kitapcidayi.kitapcidayi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("FROM Book b LEFT JOIN Issue i ON b = i.book WHERE i.user = :userId")
    List<Book> listCurrentUserBooks(@Param("userId")User userId);

}
