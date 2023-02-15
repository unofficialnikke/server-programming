package hh.survey.Survey.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.survey.Survey.domain.Survey;
import hh.survey.Survey.domain.SurveyRepository;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepo;
	
	/*
	 * Method for adding a new survey. 
	 */
	
	@GetMapping(value="/addsurvey")
	public String addSurvey(Model model) {
		//Empty object for a new survey.
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}
	
	// User friendly front-page for navigation
	@GetMapping("/")
	public String frontPage() {
		return "home";
	}
	
	//  gets all the surveys and prints to allsurveys- page
	@GetMapping("/allsurveys")
	public String allSurveys(Model model) {
		model.addAttribute("surveys", surveyRepo.findAll());
		return "allsurveys";
	}
	
	/*
	 * Saves the new survey. Return to addquestions endpoint.
	 * There user can add questions to survey.
	 */
	
	@PostMapping(value="/save")
	public String saveSurvey(@ModelAttribute Survey survey) {
		surveyRepo.save(survey);
		return "redirect:/addquestions/" + survey.getSurveyId();
	}
	
	 @GetMapping("/deletesurvey/{id}")
	    public String deleteQuestion(@PathVariable("id") Long id) {
	   
	        surveyRepo.deleteById(id);
	       
	        return "redirect:/allsurveys/";
	    }
	

}
