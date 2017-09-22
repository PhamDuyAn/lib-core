package cuong.myissue.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import cuong.myissue.model.MyIssue;

import java.util.List;

public interface MyIssueService {

    MyIssue save(MyIssue iss);

    void delete(MyIssue iss);

    MyIssue findOne(String id);

    Iterable<MyIssue> findAll();

    Page<MyIssue> findByProject(String project, PageRequest pageRequest);

    List<MyIssue> findBySubject(String subject);

}