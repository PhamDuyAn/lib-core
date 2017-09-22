package cuong;

import cuong.Application;
import cuong.myissue.model.MyIssue;
import cuong.myissue.service.MyIssueService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyIssueServiceTest {

    @Autowired
    private MyIssueService myIssueService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(MyIssue.class);
        esTemplate.createIndex(MyIssue.class);
        esTemplate.putMapping(MyIssue.class);
        esTemplate.refresh(MyIssue.class);
    }

    @Test
    public void testSave() {

        MyIssue myis = new MyIssue("1", "subject1", "description1", "2017-09-21", "2017-09-22", "8", "project-test");
        MyIssue testMyIssue = myIssueService.save(myis);

        assertNotNull(testMyIssue.getId());
        assertEquals(testMyIssue.getSubject(), myis.getSubject());
        assertEquals(testMyIssue.getDescription(), myis.getDescription());
        assertEquals(testMyIssue.getStartdate(), myis.getDuedate());
        assertEquals(testMyIssue.getTotalhours(), myis.getTotalhours());
        assertEquals(testMyIssue.getProject(), myis.getProject());

    }

    @Test
    public void testFindOne() {

        MyIssue myis = new MyIssue("1", "subject1", "description1", "2017-09-21", "2017-09-22", "8", "project-test");
        myIssueService.save(myis);

        MyIssue testMyIssue = myIssueService.findOne(myis.getId());

        assertNotNull(testMyIssue.getId());
        assertEquals(testMyIssue.getSubject(), myis.getSubject());
        assertEquals(testMyIssue.getDescription(), myis.getDescription());
        assertEquals(testMyIssue.getStartdate(), myis.getDuedate());
        assertEquals(testMyIssue.getTotalhours(), myis.getTotalhours());
        assertEquals(testMyIssue.getProject(), myis.getProject());

    }

    @Test
    public void testFindByTitle() {

        MyIssue myis = new MyIssue("1", "subject1", "description1", "2017-09-21", "2017-09-22", "8", "project-test");
        myIssueService.save(myis);

        List<MyIssue> bySub = myIssueService.findBySubject(myis.getSubject());
        assertThat(bySub.size(), is(1));
    }

    @Test
    public void testFindByProject() {

        List<MyIssue> myIssueList = new ArrayList<>();

        myIssueList.add(new MyIssue("1", "subject1", "description1", "2017-09-21", "2017-09-22", "8", "project-test"));
        myIssueList.add(new MyIssue("2", "subject2", "description2", "2017-09-21", "2017-09-22", "8", "project-test"));
        myIssueList.add(new MyIssue("3", "subject3", "description3", "2017-09-21", "2017-09-22", "8", "project-test"));
        myIssueList.add(new MyIssue("4", "subject4", "description4", "2017-09-21", "2017-09-22", "8", "project-test"));
        myIssueList.add(new MyIssue("5", "subject5", "description5", "2017-09-21", "2017-09-22", "8", "project-test"));

        for (MyIssue myIssue : myIssueList) {
        	myIssueService.save(myIssue);
        }

        Page<MyIssue> byProject = myIssueService.findByProject("project-test", new PageRequest(0, 10));
        assertThat(byProject.getTotalElements(), is(5L));

    }

    @Test
    public void testDelete() {

        MyIssue myis = new MyIssue("1", "subject1", "description1", "2017-09-21", "2017-09-22", "8", "project-test");
        myIssueService.save(myis);
        myIssueService.delete(myis);
        MyIssue testMyIssue = myIssueService.findOne(myis.getId());
        assertNull(testMyIssue);
    }

}
