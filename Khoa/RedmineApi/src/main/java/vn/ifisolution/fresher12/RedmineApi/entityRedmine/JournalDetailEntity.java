package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;
//@Document(indexName = "journaldetailbean", type = "journaldetails", shards = 1, replicas = 0, refreshInterval = "-1")
public class JournalDetailEntity implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((newValue == null) ? 0 : newValue.hashCode());
		result = prime * result + ((oldValue == null) ? 0 : oldValue.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
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
		JournalDetailEntity other = (JournalDetailEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newValue == null) {
			if (other.newValue != null)
				return false;
		} else if (!newValue.equals(other.newValue))
			return false;
		if (oldValue == null) {
			if (other.oldValue != null)
				return false;
		} else if (!oldValue.equals(other.oldValue))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JournalDetailEntity [newValue=" + newValue + ", name=" + name + ", property=" + property + ", oldValue="
				+ oldValue + "]";
	}
	public JournalDetailEntity() {
		super();
	}
	public JournalDetailEntity(String newValue, String name, String property, String oldValue) {
		super();
		this.newValue = newValue;
		this.name = name;
		this.property = property;
		this.oldValue = oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public String getName() {
		return name;
	}
	public String getProperty() {
		return property;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	private static final long serialVersionUID = -9170064829669555245L;

    private String newValue;
    private String name;
    private String property;
    private String oldValue;

}
