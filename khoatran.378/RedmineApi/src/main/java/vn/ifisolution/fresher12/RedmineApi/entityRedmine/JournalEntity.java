package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class JournalEntity implements Serializable{
	private Integer id;

    private String notes;
    private UserEntity user;
    private Date createdOn;

    private final List<JournalDetailEntity> details = new ArrayList<JournalDetailEntity>();
    @Id
	public Integer getId() {
		return id;
	}

	public String getNotes() {
		return notes;
	}

	public UserEntity getUser() {
		return user;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public List<JournalDetailEntity> getDetails() {
		return details;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public JournalEntity() {
		super();
	}

	public JournalEntity(Integer id, String notes, UserEntity user, Date createdOn) {
		super();
		this.id = id;
		this.notes = notes;
		this.user = user;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "JournalEntity [id=" + id + ", notes=" + notes + ", user=" + user + ", createdOn=" + createdOn
				+ ", details=" + details + "]";
	}
    

}
