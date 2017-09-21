package com.mkyong;

import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.mkyong.book.model.IssuesDemo;
import com.mkyong.book.repository.IssuesDemoRepository;
import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private IssuesDemoRepository issu;
	// @Autowired
	// private BookService bookService;

	public static void main(String args[]) throws RedmineException {
		SpringApplication.run(Application.class, args);

	}

	public void addIssues() throws RedmineException {
		// String uri = "http://apis.ifisolution.local:8080/projects/training-project";
		// String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
		// String projectKey = "training-project";
		// Integer queryId = null; // any
		// IssuesDemo issuedemo = new IssuesDemo();
		// RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri,
		// "fresher12", "12345678");
		//
		// IssueManager issueManager = mgr.getIssueManager();
		// List<Issue> issues = issueManager.getIssues(projectKey, queryId);
		// for (Issue issue : issues) {
		// issuedemo.setId(issue.getId());
		// issuedemo.setSubject(issue.getSubject());
		//// System.out.println(issuedemo.getId());
		//// System.out.println(issuedemo.getSubject());
		// issu.save(issuedemo);
		// }

		String uri = "http://demo.redmine.org/projects/testjavademo";
		// String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
		String projectKey = "demoissue";
		Integer queryId = null; // any
		IssuesDemo issuedemo = new IssuesDemo();
		RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri, "phamduyan9x", "Phamduyan9x");
		IssueManager issueManager = mgr.getIssueManager();
		List<Issue> issues = issueManager.getIssues(projectKey, queryId);
		for (Issue issue : issues) {
			issuedemo.setId(issue.getId());
			issuedemo.setSubject(issue.getSubject());
			//issuedemo.setStartDate(issue.getStartDate());
//			issuedemo.setDueDate(issue.getDueDate());
			System.out.println(issuedemo.getId()+"----"+issuedemo.getSubject());
			issu.save(issuedemo);
		}
	}

	@Override
	public void run(String... args) throws Exception {

		printElasticSearchInfo();

		// bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa",
		// "23-FEB-2017"));
		// bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa",
		// "13-MAR-2017"));
		// bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa",
		// "21-MAR-2017"));
		//
		// // fuzzey search
		// Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0,
		// 10));

		// List<Book> books = bookService.findByTitle("Elasticsearch Basics");

		// books.forEach(x -> System.out.println(x));
		addIssues();

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