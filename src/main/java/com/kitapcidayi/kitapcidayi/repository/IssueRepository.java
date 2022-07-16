package com.kitapcidayi.kitapcidayi.repository;

import com.kitapcidayi.kitapcidayi.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface IssueRepository extends JpaRepository <Issue, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Issue i WHERE i.pickedUp IS false AND i.expectedPickup < :date")
    void deleteNotPickedUpIssues(@Param("date") Date date);



}
