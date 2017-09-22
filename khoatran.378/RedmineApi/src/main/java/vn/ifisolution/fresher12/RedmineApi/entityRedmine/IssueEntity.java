package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "issueifi", type = "issues_", shards = 1, replicas = 0, refreshInterval = "-1")
public class IssueEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String subject;
    private Integer parentId;
    private Float estimatedHours;
    private Float spentHours;
    private UserEntity assignee;
    private String priorityText;
    private Integer priorityId;
    private Integer doneRatio;
    private ProjectEntity project;
    private UserEntity author;
    private Date startDate;
    private Date dueDate;
    private TrackerEntity tracker;
    private String description;
    private Date createdOn;
    private Date updatedOn;
    private Integer statusId;
    private String statusName;
    private VersionEntity targetVersion;
    private IssueCategoryEntity category;

    /**
     * Some comment describing the issue update
     */
    private String notes;

    /**
     * can't have two custom fields with the same ID in the collection, that's why it is declared
     * as a Set, not a List.
     */
    private final Set<CustomFieldEntity> customFields = new HashSet<CustomFieldEntity>();
    private final Set<JournalEntity> journals = new HashSet<JournalEntity>();
    private final Set<IssueRelationEntity> relations = new HashSet<IssueRelationEntity>();
    private final Set<AttachmentEntity> attachments = new HashSet<AttachmentEntity>();
    private final Set<ChangesetEntity> changesets = new HashSet<ChangesetEntity>();
    private final Set<WatcherEntity> watchers = new HashSet<WatcherEntity>();
    @Id
	public Integer getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public Integer getParentId() {
		return parentId;
	}
	public Float getEstimatedHours() {
		return estimatedHours;
	}
	public Float getSpentHours() {
		return spentHours;
	}
	public UserEntity getAssignee() {
		return assignee;
	}
	public String getPriorityText() {
		return priorityText;
	}
	public Integer getPriorityId() {
		return priorityId;
	}
	public Integer getDoneRatio() {
		return doneRatio;
	}
	public ProjectEntity getProject() {
		return project;
	}
	public UserEntity getAuthor() {
		return author;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public TrackerEntity getTracker() {
		return tracker;
	}
	public String getDescription() {
		return description;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public VersionEntity getTargetVersion() {
		return targetVersion;
	}
	public IssueCategoryEntity getCategory() {
		return category;
	}
	public String getNotes() {
		return notes;
	}
	public Set<CustomFieldEntity> getCustomFields() {
		return customFields;
	}
	public Set<JournalEntity> getJournals() {
		return journals;
	}
	public Set<IssueRelationEntity> getRelations() {
		return relations;
	}
	public Set<AttachmentEntity> getAttachments() {
		return attachments;
	}
	public Set<ChangesetEntity> getChangesets() {
		return changesets;
	}
	public Set<WatcherEntity> getWatchers() {
		return watchers;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public void setEstimatedHours(Float estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public void setSpentHours(Float spentHours) {
		this.spentHours = spentHours;
	}
	public void setAssignee(UserEntity assignee) {
		this.assignee = assignee;
	}
	public void setPriorityText(String priorityText) {
		this.priorityText = priorityText;
	}
	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}
	public void setDoneRatio(Integer doneRatio) {
		this.doneRatio = doneRatio;
	}
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	public void setAuthor(UserEntity author) {
		this.author = author;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setTracker(TrackerEntity tracker) {
		this.tracker = tracker;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public void setTargetVersion(VersionEntity targetVersion) {
		this.targetVersion = targetVersion;
	}
	public void setCategory(IssueCategoryEntity category) {
		this.category = category;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public IssueEntity(Integer id, String subject, Integer parentId, Float estimatedHours, Float spentHours,
			UserEntity assignee, String priorityText, Integer priorityId, Integer doneRatio, ProjectEntity project,
			UserEntity author, Date startDate, Date dueDate, TrackerEntity tracker, String description, Date createdOn,
			Date updatedOn, Integer statusId, String statusName, VersionEntity targetVersion,
			IssueCategoryEntity category, String notes) {
		super();
		this.id = id;
		this.subject = subject;
		this.parentId = parentId;
		this.estimatedHours = estimatedHours;
		this.spentHours = spentHours;
		this.assignee = assignee;
		this.priorityText = priorityText;
		this.priorityId = priorityId;
		this.doneRatio = doneRatio;
		this.project = project;
		this.author = author;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.tracker = tracker;
		this.description = description;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.statusId = statusId;
		this.statusName = statusName;
		this.targetVersion = targetVersion;
		this.category = category;
		this.notes = notes;
	}
	public IssueEntity() {
		super();
	}
	@Override
	public String toString() {
		return "IssueEntity [id=" + id + ", subject=" + subject + ", parentId=" + parentId + ", estimatedHours="
				+ estimatedHours + ", spentHours=" + spentHours + ", assignee=" + assignee + ", priorityText="
				+ priorityText + ", priorityId=" + priorityId + ", doneRatio=" + doneRatio + ", project=" + project
				+ ", author=" + author + ", startDate=" + startDate + ", dueDate=" + dueDate + ", tracker=" + tracker
				+ ", description=" + description + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ ", statusId=" + statusId + ", statusName=" + statusName + ", targetVersion=" + targetVersion
				+ ", category=" + category + ", notes=" + notes + ", customFields=" + customFields + ", journals="
				+ journals + ", relations=" + relations + ", attachments=" + attachments + ", changesets=" + changesets
				+ ", watchers=" + watchers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
		result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((changesets == null) ? 0 : changesets.hashCode());
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((doneRatio == null) ? 0 : doneRatio.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((estimatedHours == null) ? 0 : estimatedHours.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((journals == null) ? 0 : journals.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((priorityId == null) ? 0 : priorityId.hashCode());
		result = prime * result + ((priorityText == null) ? 0 : priorityText.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((relations == null) ? 0 : relations.hashCode());
		result = prime * result + ((spentHours == null) ? 0 : spentHours.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((targetVersion == null) ? 0 : targetVersion.hashCode());
		result = prime * result + ((tracker == null) ? 0 : tracker.hashCode());
		result = prime * result + ((updatedOn == null) ? 0 : updatedOn.hashCode());
		result = prime * result + ((watchers == null) ? 0 : watchers.hashCode());
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
		IssueEntity other = (IssueEntity) obj;
		if (assignee == null) {
			if (other.assignee != null)
				return false;
		} else if (!assignee.equals(other.assignee))
			return false;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (changesets == null) {
			if (other.changesets != null)
				return false;
		} else if (!changesets.equals(other.changesets))
			return false;
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
		if (doneRatio == null) {
			if (other.doneRatio != null)
				return false;
		} else if (!doneRatio.equals(other.doneRatio))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (estimatedHours == null) {
			if (other.estimatedHours != null)
				return false;
		} else if (!estimatedHours.equals(other.estimatedHours))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (journals == null) {
			if (other.journals != null)
				return false;
		} else if (!journals.equals(other.journals))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (priorityId == null) {
			if (other.priorityId != null)
				return false;
		} else if (!priorityId.equals(other.priorityId))
			return false;
		if (priorityText == null) {
			if (other.priorityText != null)
				return false;
		} else if (!priorityText.equals(other.priorityText))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (relations == null) {
			if (other.relations != null)
				return false;
		} else if (!relations.equals(other.relations))
			return false;
		if (spentHours == null) {
			if (other.spentHours != null)
				return false;
		} else if (!spentHours.equals(other.spentHours))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (targetVersion == null) {
			if (other.targetVersion != null)
				return false;
		} else if (!targetVersion.equals(other.targetVersion))
			return false;
		if (tracker == null) {
			if (other.tracker != null)
				return false;
		} else if (!tracker.equals(other.tracker))
			return false;
		if (updatedOn == null) {
			if (other.updatedOn != null)
				return false;
		} else if (!updatedOn.equals(other.updatedOn))
			return false;
		if (watchers == null) {
			if (other.watchers != null)
				return false;
		} else if (!watchers.equals(other.watchers))
			return false;
		return true;
	}
    

}
