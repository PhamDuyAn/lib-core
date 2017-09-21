package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "changesetbean", type = "changesets", shards = 1, replicas = 0, refreshInterval = "-1")
public class ChangesetEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String revision;
	private UserEntity user;
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getComments() {
		return comments;
	}
	@Override
	public String toString() {
		return "ChangesetEntity [revision=" + revision + ", user=" + user + ", comments=" + comments + ", committedOn="
				+ committedOn + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((committedOn == null) ? 0 : committedOn.hashCode());
		result = prime * result + ((revision == null) ? 0 : revision.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		ChangesetEntity other = (ChangesetEntity) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (committedOn == null) {
			if (other.committedOn != null)
				return false;
		} else if (!committedOn.equals(other.committedOn))
			return false;
		if (revision == null) {
			if (other.revision != null)
				return false;
		} else if (!revision.equals(other.revision))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	public ChangesetEntity(String revision, UserEntity user, String comments, Date committedOn) {
		super();
		this.revision = revision;
		this.user = user;
		this.comments = comments;
		this.committedOn = committedOn;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCommittedOn() {
		return committedOn;
	}
	public void setCommittedOn(Date committedOn) {
		this.committedOn = committedOn;
	}
	private String comments;
	private Date committedOn;

}
