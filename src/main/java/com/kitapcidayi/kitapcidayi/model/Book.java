package com.kitapcidayi.kitapcidayi.model;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BID;

    @NotNull
    @Size(min=2, max=99, message = "Bookname must be between 2-99 characters!")
    @Column(name = "bookname",nullable = false)
    private String bookName;

    @Column(name = "category",nullable = false)
    private String category;

    @NotNull
    @Digits(integer = 20, fraction = 0, message = "ISBN must be only number between 2-20 characters!")
    @Size(min=2, max=20, message = "ISBN must be only number between 2-20 characters!")
    @Column(name = "isbn",nullable = false)
    private String isbn;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,mappedBy = "book")
    @ToString.Exclude
    private List<Issue> issue;


    public Book() {

    }

    public Book(String bookName, String category, String isbn) {
        this.bookName = bookName;
        this.category = category;
        this.isbn = isbn;
    }

    public Long getBID() {
        return BID;
    }

    public void setBID(Long BID) {
        this.BID = BID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issues) {
        this.issue = issues;
    }
}
