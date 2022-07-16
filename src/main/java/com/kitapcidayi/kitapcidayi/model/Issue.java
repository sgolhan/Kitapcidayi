package com.kitapcidayi.kitapcidayi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueid;

    //@Temporal(TemporalType.DATE)
    @Column(name = "issuedate")
    private Date issueDate;

    @Column(name = "returndate")
    private Date returnDate;

    @Column(name = "pickedup")
    private Boolean pickedUp;

    @Column(name = "expectedpickup")
    private Date expectedPickup;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "BID", name = "books_id")
    private Book book;


    public Issue() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Issue(Date issueDate, Date returnDate, Date expectedPickup, Boolean pickedUp) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.expectedPickup = expectedPickup;
        this.pickedUp = pickedUp;
    }

    public Long getIssueid() {
        return issueid;
    }

    public void setIssueid(Long issueid) {
        this.issueid = issueid;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(Boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Date getExpectedPickup() {
        return expectedPickup;
    }

    public void setExpectedPickup(Date expectedPickup) {
        this.expectedPickup = expectedPickup;
    }

    public void setUser(Long id) {
    }
}
