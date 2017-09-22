package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "customfieldbean", type = "customfields", shards = 1, replicas = 0, refreshInterval = "-1")
public class CustomFieldEntity implements Serializable{
	private Integer id;
    private String name;
    private String value;
    private boolean multiple = false;
	private List<String> values;
	@Id
	public Integer getId() {
		return id;
	}
	public CustomFieldEntity() {
		super();
	}
	public CustomFieldEntity(Integer id, String name, String value, boolean multiple, List<String> values) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.multiple = multiple;
		this.values = values;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (multiple ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		CustomFieldEntity other = (CustomFieldEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multiple != other.multiple)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomFieldEntity [id=" + id + ", name=" + name + ", value=" + value + ", multiple=" + multiple
				+ ", values=" + values + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isMultiple() {
		return multiple;
	}
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	

}
