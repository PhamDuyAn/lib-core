package cuong.myissue.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "training-project", type = "issues")
public class MyIssue {

    @Id
    private String id;

    private String subject;

    private String description;

    private String startdate;
    
    private String duedate;
    
    private String totalhours;
    
    private String project;

    public MyIssue() {
    }    

	public MyIssue(String id, String subject, String description, String startdate, String duedate, String totalhours, String project) {
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.startdate = startdate;
		this.duedate = duedate;
		this.totalhours = totalhours;
		this.project = project;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getTotalhours() {
		return totalhours;
	}

	public void setTotalhours(String totalhours) {
		this.totalhours = totalhours;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "MyIssue [id=" + id + ", subject=" + subject + ", description=" + description + ", startdate="
				+ startdate + ", duedate=" + duedate + ", totalhours=" + totalhours + ", project=" + project + "]";
	}
    
}
