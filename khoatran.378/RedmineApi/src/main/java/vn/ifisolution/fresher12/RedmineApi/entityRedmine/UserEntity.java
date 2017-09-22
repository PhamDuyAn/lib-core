package vn.ifisolution.fresher12.RedmineApi.entityRedmine;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "userbean", type = "users", shards = 1, replicas = 0, refreshInterval = "-1")
public class UserEntity {
	public static final Integer STATUS_LOCKED = 3;

    public static final Integer STATUS_ACTIVE = 1;

    /**
     * database ID.
     */
    private Integer id;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String mail;
    private Date createdOn;
    private Date lastLoginOn;
    private String apiKey;
    private Integer authSourceId;
    private Integer status;
    // TODO add tests
    private final Set<CustomFieldEntity> customFields = new HashSet<CustomFieldEntity>();
	private final Set<MembershipEntity> memberships = new HashSet<MembershipEntity>();
	
	private final Set<GroupEntity> groups = new HashSet<GroupEntity>();
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mail=" + mail + ", createdOn=" + createdOn + ", lastLoginOn="
				+ lastLoginOn + ", apiKey=" + apiKey + ", authSourceId=" + authSourceId + ", status=" + status
				+ ", customFields=" + customFields + ", memberships=" + memberships + ", groups=" + groups + "]";
	}
	@Id
	public Integer getId() {
		return id;
	}
	public UserEntity(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public UserEntity() {
		super();
	}
	public UserEntity(Integer id, String login, String password, String firstName, String lastName, String mail,
			Date createdOn, Date lastLoginOn, String apiKey, Integer authSourceId, Integer status) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.createdOn = createdOn;
		this.lastLoginOn = lastLoginOn;
		this.apiKey = apiKey;
		this.authSourceId = authSourceId;
		this.status = status;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMail() {
		return mail;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public Date getLastLoginOn() {
		return lastLoginOn;
	}
	public String getApiKey() {
		return apiKey;
	}
	public Integer getAuthSourceId() {
		return authSourceId;
	}
	public Integer getStatus() {
		return status;
	}
	public Set<CustomFieldEntity> getCustomFields() {
		return customFields;
	}
	public Set<MembershipEntity> getMemberships() {
		return memberships;
	}
	public Set<GroupEntity> getGroups() {
		return groups;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public void setLastLoginOn(Date lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public void setAuthSourceId(Integer authSourceId) {
		this.authSourceId = authSourceId;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
