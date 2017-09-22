package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "projectifi", type = "projects_", shards = 1, replicas = 0, refreshInterval = "-1")
public class ProjectEntity implements Serializable{
	public ProjectEntity() {
		super();
	}

	private static final long serialVersionUID = 4529305420978716446L;

	/**
	 * database ID
	 */
    private Integer id;

    /**
     * String "identifier" (human-readable name without spaces and other extra stuff)
     */
    private String identifier;

    /**
     * Can contain any symbols
     */
    private String name;

    private String description;

    private String homepage;

    private Date createdOn;

    private Date updatedOn;

    /**
     * This is the *database ID*, not a String-based key.
     */
    private Integer parentId;
    private Boolean projectPublic;

    private final Collection<CustomFieldEntity> customFields = new HashSet<CustomFieldEntity>();

    /**
     * Trackers available for this project
     */
    private final Collection<TrackerEntity> trackers = new HashSet<TrackerEntity>();

	public ProjectEntity(Integer id, String identifier, String name, String description, String homepage,
			Date createdOn, Date updatedOn, Integer parentId, Boolean projectPublic) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.homepage = homepage;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.parentId = parentId;
		this.projectPublic = projectPublic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	public Integer getId() {
		return id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getHomepage() {
		return homepage;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public Integer getParentId() {
		return parentId;
	}

	public Boolean getProjectPublic() {
		return projectPublic;
	}

	public Collection<CustomFieldEntity> getCustomFields() {
		return customFields;
	}

	public Collection<TrackerEntity> getTrackers() {
		return trackers;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public void setProjectPublic(Boolean projectPublic) {
		this.projectPublic = projectPublic;
	}

	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", identifier=" + identifier + ", name=" + name + ", description="
				+ description + ", homepage=" + homepage + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", parentId=" + parentId + ", projectPublic=" + projectPublic + ", customFields=" + customFields
				+ ", trackers=" + trackers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((projectPublic == null) ? 0 : projectPublic.hashCode());
		result = prime * result + ((trackers == null) ? 0 : trackers.hashCode());
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
		ProjectEntity other = (ProjectEntity) obj;
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
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (projectPublic == null) {
			if (other.projectPublic != null)
				return false;
		} else if (!projectPublic.equals(other.projectPublic))
			return false;
		if (trackers == null) {
			if (other.trackers != null)
				return false;
		} else if (!trackers.equals(other.trackers))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		return true;
	}
    

}
