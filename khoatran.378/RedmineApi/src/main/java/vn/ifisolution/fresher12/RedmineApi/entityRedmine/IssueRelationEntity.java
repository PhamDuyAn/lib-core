package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "issuerelationbean", type = "issuerelations", shards = 1, replicas = 0, refreshInterval = "-1")
public class IssueRelationEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer issueId;
    private Integer issueToId;
    private String type;
    private Integer delay;
    @Id
	public Integer getId() {
		return id;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public Integer getIssueToId() {
		return issueToId;
	}
	public String getType() {
		return type;
	}
	public Integer getDelay() {
		return delay;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public void setIssueToId(Integer issueToId) {
		this.issueToId = issueToId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	@Override
	public String toString() {
		return "IssueRelationEntity [id=" + id + ", issueId=" + issueId + ", issueToId=" + issueToId + ", type=" + type
				+ ", delay=" + delay + "]";
	}
	public IssueRelationEntity(Integer id, Integer issueId, Integer issueToId, String type, Integer delay) {
		super();
		this.id = id;
		this.issueId = issueId;
		this.issueToId = issueToId;
		this.type = type;
		this.delay = delay;
	}
	public IssueRelationEntity() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delay == null) ? 0 : delay.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issueId == null) ? 0 : issueId.hashCode());
		result = prime * result + ((issueToId == null) ? 0 : issueToId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		IssueRelationEntity other = (IssueRelationEntity) obj;
		if (delay == null) {
			if (other.delay != null)
				return false;
		} else if (!delay.equals(other.delay))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issueId == null) {
			if (other.issueId != null)
				return false;
		} else if (!issueId.equals(other.issueId))
			return false;
		if (issueToId == null) {
			if (other.issueToId != null)
				return false;
		} else if (!issueToId.equals(other.issueToId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
    
}
