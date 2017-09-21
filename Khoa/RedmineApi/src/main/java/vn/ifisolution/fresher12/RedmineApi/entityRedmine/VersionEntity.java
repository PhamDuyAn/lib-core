package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "versionbean", type = "versions", shards = 1, replicas = 0, refreshInterval = "-1")
public class VersionEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String STATUS_OPEN = "open";
    public static final String STATUS_LOCKED = "locked";
    public static final String STATUS_CLOSED = "closed";

    public static final String SHARING_NONE = "none";
    public static final String SHARING_DESCENDANTS = "descendants";
    public static final String SHARING_HIERARCHY = "hierarchy";
    public static final String SHARING_TREE = "tree";
    public static final String SHARING_SYSTEM = "system";

    private Integer id;
    private ProjectEntity project;
    private String name;
    private String description;
    private String status;
    private Date dueDate;
    private String sharing;
    private Date createdOn;
    private Date updatedOn;

    private final Collection<CustomFieldEntity> customFields = new HashSet<CustomFieldEntity>();
    @Id
	public Integer getId() {
		return id;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public String getSharing() {
		return sharing;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public Collection<CustomFieldEntity> getCustomFields() {
		return customFields;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setSharing(String sharing) {
		this.sharing = sharing;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public VersionEntity(Integer id, ProjectEntity project, String name, String description, String status,
			Date dueDate, String sharing, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.project = project;
		this.name = name;
		this.description = description;
		this.status = status;
		this.dueDate = dueDate;
		this.sharing = sharing;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "VersionEntity [id=" + id + ", project=" + project + ", name=" + name + ", description=" + description
				+ ", status=" + status + ", dueDate=" + dueDate + ", sharing=" + sharing + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", customFields=" + customFields + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((sharing == null) ? 0 : sharing.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedOn == null) ? 0 : updatedOn.hashCode());
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
		VersionEntity other = (VersionEntity) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (customFields == null) {
			if (other.customFields != null)
				return false;
		} else if (!customFields.equals(other.customFields))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
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
		if (sharing == null) {
			if (other.sharing != null)
				return false;
		} else if (!sharing.equals(other.sharing))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		return true;
	}
    
    

}
