package hh.survey.Survey.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String email;
	private String role;
	private String passwordHash;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Survey> surveys;

	public User(String username, String email, String role, String passwordHash) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.passwordHash = passwordHash;
	}
	
	public User() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", username=" + username + ", email=" + email + ", role=" + role
				+ ", passwordHash=" + passwordHash + "]";
	}
	
	
	

}
