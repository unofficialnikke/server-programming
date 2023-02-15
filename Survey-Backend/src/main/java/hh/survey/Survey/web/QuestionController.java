package hh.survey.Survey.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.survey.Survey.domain.Question;
import hh.survey.Survey.domain.QuestionRepository;
import hh.survey.Survey.domain.QuestionType;
import hh.survey.Survey.domain.SurveyRepository;


@Controller
public class QuestionController {
	
	@Autowired
	private SurveyRepository surveyRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	/*
	 * Mehtod for adding questions to specific survey. SurveyId comes in
	 * a path variable. Returns thymeleaf-template that has link for
	 * adding question to survey.
	 */
	
	@GetMapping("/addquestions/{surveyId}")
	public String addQuestionsToSurvey(@PathVariable("surveyId") Long surveyId, Model model) {
		//Finds survey with surveyId.
		model.addAttribute("survey", surveyRepo.findById(surveyId).get());
		
		return "addquestions";
	}
	
	/*
	 * Mehtod for adding question to specific survey. SurveyId comes in
	 * a path variable. Return thymeleaf-template with form.
	 */
	
	@GetMapping("/addquestion/{surveyId}")
	public String addQuestion(@PathVariable("surveyId") Long id, Question question, Model model) {
		//Finds survey with surveyId.
		model.addAttribute("survey", surveyRepo.findById(id).get());
		//Empty object for new question.
		model.addAttribute("question", new Question());
		return "addquestion";
	}
	
	/*
	 * Methods saves question to a specific survey. SurveyId comes in a
	 * path variable. Redirects to addquestions-endpoint.
	 */
	
	@PostMapping("/savequestion/{surveyId}")
	public String saveQuestion(@PathVariable("surveyId") Long id,@ModelAttribute Question question, Model model) {
		//Finds survey with surveyId.
		model.addAttribute("survey", surveyRepo.findById(id));
		//Sets survey for question. With this the question is set to right survey.
		question.setSurvey(surveyRepo.findById(id).get());
		//Saves the new question.
		questionRepo.save(question);
		
		model.addAttribute("question", question);
		if(question.getType() == QuestionType.TEXT) {
			return "redirect:/addquestions/" + id;
		} else {
			return "redirect:/addoptions/"+ question.getId();
		}
		
	}
	
	/*
	 * Delete question from survey.
	 */
	
	@GetMapping("/deletequestion/{questionid}")
	public String deleteQuestion(@PathVariable("questionid") Long id) {
		Long surveyid = questionRepo.findById(id).get().getSurvey().getSurveyId();
		questionRepo.deleteById(id);
		
		return "redirect:/addquestions/" + surveyid;
	}
}
