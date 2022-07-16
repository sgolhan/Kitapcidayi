package com.kitapcidayi.kitapcidayi.service.impl;

import com.kitapcidayi.kitapcidayi.model.Issue;
import com.kitapcidayi.kitapcidayi.repository.IssueRepository;
import com.kitapcidayi.kitapcidayi.service.IssueService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    @Override
    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssueById(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).get();
    }

    @Override
    public Issue updateIssue(Issue issue) {
        return  issueRepository.save(issue);
    }

    @Override
    public void deleteNotPickedUpIssues(Date today) {
         issueRepository.deleteNotPickedUpIssues(today);
    }
}