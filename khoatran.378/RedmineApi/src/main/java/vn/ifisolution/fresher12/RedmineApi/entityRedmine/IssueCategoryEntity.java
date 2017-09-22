package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "issuecategoybean", type = "issuecategorys", shards = 1, replicas = 0, refreshInterval = "-1")
public class IssueCategoryEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	private ProjectEntity project;
	private UserEntity assignee;
	@Id
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public ProjectEntity getProject() {
		return project;
	}
	public UserEntity getAssignee() {
		return assignee;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	public void setAssignee(UserEntity assignee) {
		this.assignee = assignee;
	}
	public IssueCategoryEntity(Integer id, String name, ProjectEntity project, UserEntity assignee) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.assignee = assignee;
	}
	public IssueCategoryEntity() {
		super();
	}
	@Override
	public String toString() {
		return "IssueCategoryEntity [id=" + id + ", name=" + name + ", project=" + project + ", assignee=" + assignee
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueCategoryEntity other = (IssueCategoryEntity) obj;
		if (assignee == null) {
			if (other.assignee != null)
				return false;
		} else if (!assignee.equals(other.assignee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}
	

}
