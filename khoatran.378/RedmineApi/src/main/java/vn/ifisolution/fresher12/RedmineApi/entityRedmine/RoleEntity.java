package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "rolebean", type = "roles", shards = 1, replicas = 0, refreshInterval = "-1")
public class RoleEntity implements Serializable{
	private Integer id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inherited == null) ? 0 : inherited.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
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
		RoleEntity other = (RoleEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inherited == null) {
			if (other.inherited != null)
				return false;
		} else if (!inherited.equals(other.inherited))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", name=" + name + ", inherited=" + inherited + ", permissions=" + permissions
				+ "]";
	}
	@Id
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getInherited() {
		return inherited;
	}

	public Collection<String> getPermissions() {
		return permissions;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInherited(Boolean inherited) {
		this.inherited = inherited;
	}

	public RoleEntity() {
		super();
	}

	public RoleEntity(Integer id, String name, Boolean inherited) {
		super();
		this.id = id;
		this.name = name;
		this.inherited = inherited;
	}

	private String name;
	private Boolean inherited;

	private final Collection<String> permissions = new HashSet<String>();
}
