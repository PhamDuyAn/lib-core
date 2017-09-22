package cuong.myissue.service;

import cuong.myissue.model.MyIssue;
import cuong.myissue.repository.MyIssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyIssueServiceImpl implements MyIssueService {

    private MyIssueRepository myIssueRepository;

    @Autowired
    public void setmyIssueRepository(MyIssueRepository myIssueRepository) {
        this.myIssueRepository = myIssueRepository;
    }

    public MyIssue save(MyIssue myis) {
        return myIssueRepository.save(myis);
    }

    public void delete(MyIssue myis) {
        myIssueRepository.delete(myis);
    }

    public MyIssue findOne(String id) {
        return myIssueRepository.findOne(id);
    }

    public Iterable<MyIssue> findAll() {
        return myIssueRepository.findAll();
    }

    public Page<MyIssue> findByProject(String project, PageRequest pageRequest) {
        return myIssueRepository.findByProject(project, pageRequest);
    }

    public List<MyIssue> findBySubject(String title) {
        return myIssueRepository.findBySubject(title);
    }

}