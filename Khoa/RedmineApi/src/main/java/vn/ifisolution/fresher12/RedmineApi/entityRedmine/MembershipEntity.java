package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "membershipbean", type = "memberships", shards = 1, replicas = 0, refreshInterval = "-1")
public class MembershipEntity implements Serializable{
	private Integer id;

	private ProjectEntity project;
	private UserEntity user;

    private GroupEntity group;

	private final Collection<RoleEntity> roles = new HashSet<RoleEntity>();
	@Id
	public Integer getId() {
		return id;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public UserEntity getUser() {
		return user;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public Collection<RoleEntity> getRoles() {
		return roles;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	public MembershipEntity(Integer id, ProjectEntity project, UserEntity user, GroupEntity group) {
		super();
		this.id = id;
		this.project = project;
		this.user = user;
		this.group = group;
	}

	public MembershipEntity() {
		super();
	}

	@Override
	public String toString() {
		return "MembershipEntity [id=" + id + ", project=" + project + ", user=" + user + ", group=" + group
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		MembershipEntity other = (MembershipEntity) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

}
