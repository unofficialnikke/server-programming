package hh.survey.Survey.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private QuestionType type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> options;

	@JsonIgnoreProperties("questions")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@Column(nullable = true)
	private List<Answer> answers;
	
	public Question() {
		
	}
	

	public Question(String name, Survey survey, QuestionType type) {
		super();
		this.name = name;
		this.survey = survey;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	

	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public QuestionType getType() {
		return type;
	}


	public void setType(QuestionType type) {
		this.type = type;
	}


	public List<Option> getOptions() {
		return options;
	}


	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	
	@Override
	public String toString() {
		return "Question [id=" + ", name=" + name + ", survey=" + this.survey.getSurveyName() + "]";
	}
	
	
	
	
}
