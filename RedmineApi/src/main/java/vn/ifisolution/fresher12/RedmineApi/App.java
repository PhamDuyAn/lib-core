package vn.ifisolution.fresher12.RedmineApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

import vn.ifisolution.fresher12.RedmineApi.entityRedmine.IssueEntity;
import vn.ifisolution.fresher12.RedmineApi.entityRedmine.TrackerEntity;
import vn.ifisolution.fresher12.RedmineApi.entityRedmine.UserEntity;
import vn.ifisolution.fresher12.RedmineApi.repository.IssueEntityRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	@Autowired
	private IssueEntityRepository issueEntityRepository;
	public static void main( String[] args ) {
		SpringApplication.run(App.class);
//		String uri = "http://www.hostedredmine.com/";
//	    String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
//	    String projectKey = "taskconnector-test";
//	    Integer queryId = null; // any
//
//	    RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
//	    IssueManager issueManager = mgr.getIssueManager();
//	    List<Issue> issues;
//	    ArrayList<IssueEntity> issueEntity = new ArrayList<IssueEntity>();
//		try {
//			issues = issueManager.getIssues(projectKey, queryId);
//			System.out.println(issues.size());
//			for (Issue issue : issues) {
////				System.out.println(issue.getAuthor().toString());
//				IssueEntity issueEntity2 = new IssueEntity();
//				issueEntity2.setId(issue.getId());
//				issueEntity2.setSubject(issue.getSubject());
////				issueEntity2.setAssignee(new UserEntity());
//				issueEntity2.setDescription(issue.getDescription());
//				issueEntity2.setDueDate(issue.getDueDate());
//				issueEntity2.setStartDate(issue.getStartDate());
//				issueEntity2.setTracker(new TrackerEntity(issue.getTracker().getId(), issue.getTracker().getName()));
//				issueEntity2.setPriorityId(issue.getPriorityId());
//				issueEntity2.setPriorityText(issue.getPriorityText());
////				issueEntity2.setAuthor(new UserEntity(issue.getAuthor().getId()==null?0:issue.getAuthor().getId(), issue.getAuthor().getLogin()==null?"_":issue.getAuthor().getLogin(), issue.getAuthor().getPassword()==null?"_none_":issue.getAuthor().getPassword(), issue.getAuthor().getFirstName()==null?"none":issue.getAuthor().getFirstName(), issue.getAuthor().getLastName()==null?"none":issue.getAssignee().getLastName(), issue.getAssignee().getMail()==null?"none":issue.getAssignee().getMail(), issue.getAuthor().getCreatedOn(),issue.getAuthor().getCreatedOn()==null?null:issue.getAuthor().getLastLoginOn(), issue.getAssignee().getApiKey()==null?"none": issue.getAssignee().getApiKey(), issue.getAuthor().getAuthSourceId()==null?0:issue.getAuthor().getAuthSourceId(), issue.getStatusId()==null?0:issue.getStatusId()));
//				issueEntity2.setAuthor(new UserEntity(issue.getAuthor().getId(), issue.getAuthor().getFirstName(), issue.getAuthor().getLastName()));
//				System.out.println(issueEntity2.toString());
//				
//			}
//		} catch (RedmineException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//    
    // Create issue
//    Issue issueToCreate = 	IssueFactory.create(1, "some subject");
//    Issue issueToCreate = IssueFactory.createWithSubject("some subject");
//    Issue createdIssue = issueManager.createIssue(projectKey , issueToCreate);

    // Get issue by ID:
//    Issue issue = issueManager.getIssueById(123);	
}

	public void run(String... args) throws Exception {
//		String uri = "http://www.hostedredmine.com/";
		String uri = "http://www.redmine.org/projects/redmine/";
	    String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
	    String projectKey = "taskconnector-test";
	    Integer queryId = null; // any

	    RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
	    IssueManager issueManager = mgr.getIssueManager();
	    List<Issue> issues;
	    ArrayList<IssueEntity> issueEntity = new ArrayList<IssueEntity>();
		try {
			issues = issueManager.getIssues(projectKey, queryId);
			System.out.println(issues.size());
			for (Issue issue : issues) {
//				System.out.println(issue.getAuthor().toString());
				IssueEntity issueEntity2 = new IssueEntity();
				issueEntity2.setId(issue.getId());
				issueEntity2.setSubject(issue.getSubject());
//				issueEntity2.setAssignee(new UserEntity());
				issueEntity2.setDescription(issue.getDescription());
				issueEntity2.setDueDate(issue.getDueDate());
				issueEntity2.setStartDate(issue.getStartDate());
				issueEntity2.setTracker(new TrackerEntity(issue.getTracker().getId(), issue.getTracker().getName()));
				issueEntity2.setPriorityId(issue.getPriorityId());
				issueEntity2.setPriorityText(issue.getPriorityText());
//				issueEntity2.setAuthor(new UserEntity(issue.getAuthor().getId()==null?0:issue.getAuthor().getId(), issue.getAuthor().getLogin()==null?"_":issue.getAuthor().getLogin(), issue.getAuthor().getPassword()==null?"_none_":issue.getAuthor().getPassword(), issue.getAuthor().getFirstName()==null?"none":issue.getAuthor().getFirstName(), issue.getAuthor().getLastName()==null?"none":issue.getAssignee().getLastName(), issue.getAssignee().getMail()==null?"none":issue.getAssignee().getMail(), issue.getAuthor().getCreatedOn(),issue.getAuthor().getCreatedOn()==null?null:issue.getAuthor().getLastLoginOn(), issue.getAssignee().getApiKey()==null?"none": issue.getAssignee().getApiKey(), issue.getAuthor().getAuthSourceId()==null?0:issue.getAuthor().getAuthSourceId(), issue.getStatusId()==null?0:issue.getStatusId()));
				issueEntity2.setAuthor(new UserEntity(issue.getAuthor().getId(), issue.getAuthor().getFirstName(), issue.getAuthor().getLastName()));
				issueEntity2.setCreatedOn(issue.getCreatedOn());
				issueEntity2.setUpdatedOn(issue.getUpdatedOn());
				issueEntity2.setEstimatedHours(issue.getEstimatedHours());
				issueEntity2.setDoneRatio(issue.getDoneRatio());
				issueEntity2.setDescription(issue.getDescription());
				if(issue.getAssignee()!=null)
				issueEntity2.setAssignee(new UserEntity(issue.getAssignee().getId(), issue.getAssignee().getFirstName()==null?"none":issue.getAssignee().getFirstName(),issue.getAssignee().getLastName()==null?"none":issue.getAssignee().getLastName()));
				System.out.println(issueEntity2.toString());
				issueEntity.add(issueEntity2);				
				
			}
			Iterable<IssueEntity> issueIter = issueEntity;
			issueEntityRepository.saveAll(issueIter);
		} catch (RedmineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
