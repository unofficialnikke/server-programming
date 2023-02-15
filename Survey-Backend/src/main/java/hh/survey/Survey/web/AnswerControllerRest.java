package hh.survey.Survey.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import hh.survey.Survey.domain.Answer;
import hh.survey.Survey.domain.AnswerRepository;
import hh.survey.Survey.domain.Question;
import hh.survey.Survey.domain.QuestionRepository;

@CrossOrigin
@RestController
public class AnswerControllerRest {
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private AnswerRepository answerRepo;
	
	@GetMapping("/answers")
	public @ResponseBody List<Answer> getAnswers() {
		return (List<Answer>) answerRepo.findAll();
	}
	
	/*
	 * Method for saving answers to survey.
	 */
	
	@PostMapping(value = "/answers")
	public String saveAnswer(@RequestBody String answerFromFront) {
		try {
			// Parses jsonArray from a string.
			JsonArray jsonAnswers = JsonParser.parseString(answerFromFront).getAsJsonArray();
			// Loops through an array and gets all the questions and answers from json.
			for (int i = 0; i < jsonAnswers.size(); i++) {
				// Empty object for new answer.
				Answer answer = new Answer();
				// Gets question name from json.
				Long questionid = jsonAnswers.get(i).getAsJsonObject().get("questionId").getAsLong();
				// Finds question from database.
				Question question = questionRepo.findById(questionid).get();
				// Gets question reply from json.
				String reply = jsonAnswers.get(i).getAsJsonObject().get("reply").getAsString();
				// Using setters to set reply and question for answer. Finally saves the answer.
				answer.setReply(reply);
				answer.setQuestion(question);
				answerRepo.save(answer);
			}
			return "";
		} catch (JsonSyntaxException e) {
			System.err.println(e);
			return "";
		} catch (NullPointerException e) {
			System.err.println(e);
			return "";
		} catch (Exception e) {
			System.err.println(e);
			return "";
		}
	}
}
