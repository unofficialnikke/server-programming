package hh.survey.Survey.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long surveyId;
	private String surveyName;
	
	@Column(length = 1000)
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	private List<Question> questions;

	@JsonIgnore
	@JsonIgnoreProperties("surveys")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Survey() {

	}

	public Survey(String surveyName, String description, Date date, User user) {
		super();
		this.surveyName = surveyName;
		this.description = description;
		this.date = date;
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyName=" + surveyName + ", description=" + description
				+ ", date=" + date ;
	}

}
