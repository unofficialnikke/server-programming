package hh.survey.Survey.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.survey.Survey.domain.Option;
import hh.survey.Survey.domain.OptionRepository;

import hh.survey.Survey.domain.QuestionRepository;
import hh.survey.Survey.domain.SurveyRepository;

@Controller
public class OptionController {

	@Autowired
	private OptionRepository Orepository;

	@Autowired
	private QuestionRepository Qrepository;
	@Autowired
	private SurveyRepository Srepository;

	@GetMapping("addoptions/{questionId}")
	public String AddOptionsToSurvey (@PathVariable("questionId")Long id, Model model, Option option) {
		model.addAttribute("question", Qrepository.findById(id).get());
		model.addAttribute("survey",Srepository.findById(Qrepository.findById(id).get().getSurvey().getSurveyId()).get());
		model.addAttribute("option", new Option());
		return "addoptions";
	}

	@PostMapping("/saveoption/{questionId}")
	public String saveOption (@PathVariable("questionId")Long id, @ModelAttribute Option option, Model model) {
		model.addAttribute("question", Qrepository.findById(id).get());
		model.addAttribute("survey",Srepository.findById(Qrepository.findById(id).get().getSurvey().getSurveyId()).get());
		option.setQuestion(Qrepository.findById(id).get());
		
		Orepository.save(option);
		
		return "redirect:/addoptions/" + id ;
	}
	
}
