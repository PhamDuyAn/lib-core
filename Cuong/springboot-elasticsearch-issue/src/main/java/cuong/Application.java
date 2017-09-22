package cuong;

import cuong.myissue.model.MyIssue;
import cuong.myissue.service.MyIssueService;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private MyIssueService myIssueService;

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		printElasticSearchInfo();

		String uri = "https://www.hostedredmine.com";
		String apiAccessKey = "8bcb9fdba62a76d668126a171a455e86fd0e4d67";
		String projectKey = "project-cuong-test";
		Integer queryId = null; // any

		RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
		IssueManager issueManager = mgr.getIssueManager();
		List<Issue> issuesList = issueManager.getIssues(projectKey, queryId);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		for (Issue issue : issuesList) {
			
//			System.out.println("id:" + issue.getId());
//			System.out.println("subject:" + issue.getSubject());
//			System.out.println("description:" + issue.getDescription());
//			System.out.println("startdate:" + issue.getStartDate());
//			System.out.println("duedate:" + issue.getDueDate());
//			System.out.println("totalhours:" + issue.getSpentHours());
//			System.out.println("project:" + issue.getProject().getName());
//			System.out.println();

			myIssueService.save(new MyIssue("" + issue.getId(), issue.getSubject(), issue.getDescription(),
					df.format(issue.getStartDate()), df.format(issue.getDueDate()), "" + issue.getSpentHours(),
					issue.getProject().getName()));
		}

	}

	// useful for debug
	private void printElasticSearchInfo() {

		System.out.println("--ElasticSearch-->");
		Client client = es.getClient();
		Map<String, String> asMap = client.settings().getAsMap();

		asMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});
		System.out.println("<--ElasticSearch--");
	}

}