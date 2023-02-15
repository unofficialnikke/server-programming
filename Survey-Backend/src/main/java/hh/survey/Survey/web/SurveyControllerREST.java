package hh.survey.Survey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.survey.Survey.domain.Question;
import hh.survey.Survey.domain.Survey;
import hh.survey.Survey.domain.SurveyRepository;

@CrossOrigin
@RestController
public class SurveyControllerREST {

	@Autowired
	private SurveyRepository surveyRepo;
	
	// find all surveys RESTful service as json form
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> getAllSurveys() {
		return (List<Survey>) surveyRepo.findAll();
	}
	
	@PostMapping("/surveys")
	public @ResponseBody Survey saveSurveyRest(@RequestBody Survey survey) {
		return surveyRepo.save(survey);
	}

	/*
	 * gets all questions by one survey as json form.
	 */
	@GetMapping(value = "/surveys/{id}/questions")
	public @ResponseBody List<Question> getQuestions(@PathVariable("id") Long surveyId) {
		return (List<Question>) surveyRepo.findById(surveyId).get().getQuestions();
	}
	
	
	
	// gets survey by id as json form 
	@GetMapping("/surveys/{id}") 
	public @ResponseBody Optional<Survey> getSurveyById(@PathVariable("id") Long surveyId) {
		return surveyRepo.findById(surveyId);
	}
		 
}
