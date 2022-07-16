package com.kitapcidayi.kitapcidayi.service;

import com.kitapcidayi.kitapcidayi.model.Issue;

import java.sql.Date;
import java.util.List;

public interface IssueService {
    List<Issue> getAllIssues();
    Issue saveIssue (Issue issue);

    void deleteIssueById(Long id);

    Issue getIssueById(Long id);

    Issue updateIssue(Issue issue);

    void deleteNotPickedUpIssues(Date today);
}
