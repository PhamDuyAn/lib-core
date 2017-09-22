package cuong.myissue.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cuong.myissue.model.MyIssue;

import java.util.List;

public interface MyIssueRepository extends ElasticsearchRepository<MyIssue, String> {

    Page<MyIssue> findByProject(String project, Pageable pageable);

    List<MyIssue> findBySubject(String subject);

}