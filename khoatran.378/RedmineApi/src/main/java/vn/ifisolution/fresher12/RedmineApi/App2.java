package vn.ifisolution.fresher12.RedmineApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Project;

import vn.ifisolution.fresher12.RedmineApi.entityRedmine.ProjectEntity;
import vn.ifisolution.fresher12.RedmineApi.repository.ProjectEntityRepository;
@SpringBootApplication
public class App2 implements CommandLineRunner{
	@Autowired
	ProjectEntityRepository projectEntityRepository;
	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
//		String uri = "http://www.hostedredmine.com/";
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
//		String uri = "http://www.hostedredmine.com/";
//	    String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
//	    String projectKey = "taskconnector-test";
//	    Integer queryId = null; // any
	    System.setProperty("http.proxyHost", "10.225.3.1");
		System.setProperty("http.proxyPort", "3128");
       String uri = "http://apis.ifisolution.local:8080";
       String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";

//	    RedmineManager mgr = RedmineManagerFactory.createWithApiKey(uri, apiAccessKey);
	    RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri, "fresher12", "12345678");
	    List<Project> listProject =null;
	    ProjectManager projectManager = mgr.getProjectManager();
	    ArrayList<ProjectEntity> projectEntitys = new ArrayList<ProjectEntity>();
	    try {
			listProject = projectManager.getProjects();
			System.out.println(listProject.size());
			for(Project pro: listProject) {
				ProjectEntity projectEntity = new ProjectEntity();
				projectEntity.setCreatedOn(pro.getCreatedOn());
				projectEntity.setDescription(pro.getDescription());
				projectEntity.setHomepage(pro.getHomepage());
				projectEntity.setId(pro.getId());
				projectEntity.setName(pro.getName());
				projectEntity.setParentId(pro.getParentId());
				projectEntity.setProjectPublic(pro.getProjectPublic());
				projectEntity.setUpdatedOn(pro.getUpdatedOn());
				projectEntitys.add(projectEntity);				
			}
			projectEntityRepository.saveAll(projectEntitys);
		} catch (RedmineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
