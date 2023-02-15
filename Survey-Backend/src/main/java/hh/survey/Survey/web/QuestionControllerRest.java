package hh.survey.Survey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.survey.Survey.domain.Answer;
import hh.survey.Survey.domain.Question;
import hh.survey.Survey.domain.QuestionRepository;

@CrossOrigin
@RestController
public class QuestionControllerRest {
	
	@Autowired
	private QuestionRepository qRepository;
	
	// gets all questions as json form to web browser
	@GetMapping("/questions")
	public @ResponseBody List<Question> getAllQuestions() {
		return (List<Question>) qRepository.findAll();
	}
	// gets question by question id as json form to web browser
	@GetMapping("/questions/{id}")
	public @ResponseBody Optional<Question> getQuestionById(@PathVariable(name = "id") Long id) {
		return qRepository.findById(id);
	}
	
	// gets answers to a specific question as json form to web browser
	@GetMapping("/questions/{id}/answers")
	public @ResponseBody List<Answer> getAnswersToQuestionById(@PathVariable(name = "id") Long id) {
		return (List<Answer>) qRepository.findById(id).get().getAnswers();
	}
	
	

}
