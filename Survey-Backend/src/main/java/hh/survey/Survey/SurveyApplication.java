package hh.survey.Survey;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.survey.Survey.domain.Answer;
import hh.survey.Survey.domain.AnswerRepository;
import hh.survey.Survey.domain.Option;
import hh.survey.Survey.domain.OptionRepository;
import hh.survey.Survey.domain.Question;
import hh.survey.Survey.domain.QuestionRepository;
import hh.survey.Survey.domain.QuestionType;
import hh.survey.Survey.domain.Survey;
import hh.survey.Survey.domain.SurveyRepository;
import hh.survey.Survey.domain.User;
import hh.survey.Survey.domain.UserRepository;

@SpringBootApplication
public class SurveyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SurveyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner surveyDemo(SurveyRepository surveyRepo, QuestionRepository questionRepo, UserRepository userRepo, AnswerRepository answerRepo, OptionRepository opRepo) {
		return (args) -> {

			// Creating test user
			User testUser = new User();
			userRepo.save(testUser);
			// Creating test surveys to application
			Survey testSurvey = new Survey("Lyhyt kysely koulutuksesta","Kyselyssä kysytään muutama kysymys koulutuksesta ja sinusta.", new Date(), testUser);
			Survey exampleSurvey = new Survey("Haaga-Helia kysely", "Etä- vai lähiopetus", new Date(), testUser);
			surveyRepo.save(testSurvey);
			surveyRepo.save(exampleSurvey);
			
			// lokitetaan kyselyjen tiedot		
			for (Survey survey : surveyRepo.findAll()) {
				log.info(survey.toString());
			}
			// Creating test questions for surveys
			// Questions for testSurvey
			Question question1 = new Question("Minkä ikäinen olet?", testSurvey, QuestionType.RADIO);
			Question question2 = new Question("Mikä on koulutustasosi?", testSurvey, QuestionType.TEXT);
			Question question3 = new Question("Mikä on koulutusohjelmasi?", testSurvey, QuestionType.TEXT);
			List<Question> testQuestions = List.of(question1, question2, question3);
			questionRepo.saveAll(testQuestions);
			
			// Questions for exampleSurvey
			Question question4 = new Question("Mitä opiskelet Haaga-Heliassa?", exampleSurvey, QuestionType.TEXT);
			Question question5 = new Question("Ikäsi?", exampleSurvey, QuestionType.RADIO);
			Question question6 = new Question("Monesko opintovuosi sinulla on menossa?", exampleSurvey, QuestionType.RADIO);
			Question question7 = new Question("Kuinka kaukana asut kampukselta?", exampleSurvey, QuestionType.RADIO);
			Question question8 = new Question("Oletko aikaisemmin opiskellut korkeakoulussa?", exampleSurvey, QuestionType.RADIO);
			Question question9 = new Question("Käytkö koulun ohella töissä?", exampleSurvey, QuestionType.RADIO);
			Question question10 = new Question("Kuinka monta kurssia kurssia sinulla on tällä hetkellä?", exampleSurvey, QuestionType.RADIO);
			Question question11 = new Question("Suositko mieluummin etäopetusta, lähiopetusta vai hybridimuotoa?", exampleSurvey, QuestionType.RADIO);
			Question question12 = new Question("Miksi suosit juuri kyseistä opetusmuotoa?", exampleSurvey, QuestionType.TEXT);
			Question question13 = new Question("Vaikuttavatko toteutusmuodot kurssivalintoihisi?", exampleSurvey, QuestionType.TEXT);
			Question question14 = new Question("Olisiko vähemmän mieluuisessa opetusmuodossa jotain parannettavaa mielestäsi?", exampleSurvey, QuestionType.TEXT);
			List<Question> exampleQuestions = List.of(question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14);	
			questionRepo.saveAll(exampleQuestions);
			
			//Options for multiplechoice questions.
			Option option1 = new Option("1. vuosi", question6);
			Option option2 = new Option("2. vuosi", question6);
			Option option3 = new Option("3. vuosi", question6);
			Option option4 = new Option("4. vuosi", question6);
			Option option5 = new Option("5. vuosi", question6);	
			
			Option option6 = new Option("18-24", question5);	
			Option option7 = new Option("25-30", question5);	
			Option option8 = new Option("31-35", question5);	
			Option option9 = new Option("36 tai yli", question5);	
		
			
			Option option12 = new Option("<18", question1);
			Option option13 = new Option("18-20", question1);
			Option option28 = new Option(">20", question1);
			
			Option option14 = new Option("0-5km", question7);
			Option option15 = new Option("6-10km", question7);
			Option option16 = new Option("11-20km", question7);
			Option option17 = new Option(">20km", question7);
			
			Option option18 = new Option("Kyllä", question8);
			Option option19 = new Option("En", question8);
			
			Option option20 = new Option("Kyllä", question9);
			Option option21 = new Option("En", question9);
			
			Option option22 = new Option("1-2", question10);
			Option option23 = new Option("3-5", question10);
			Option option24 = new Option(">5", question10);
			
			Option option25 = new Option("Etäopetus", question11);
			Option option26 = new Option("Lähiopetus", question11);
			Option option27 = new Option("Hybridimuoto", question11);

			List<Option> exampleOption = List.of(option1, option2, option3, option4, option5, option6, option7, option8, option9,option12, 
					option13, option14, option15, option16, option17, option18, option19, option20, option21, option22, option23, option24,
					option25, option26, option27, option28);
			opRepo.saveAll(exampleOption);
			
			
			//Creating testanswers
			Answer answer1 = new Answer("Opiskelen tietojenkäsittelyä");
			Answer answer2 = new Answer("Opiskelen liiketaloutta");
			Answer answer3 = new Answer(option6.getName());
			Answer answer4 = new Answer(option8.getName());
			Answer answer5 = new Answer(option2.getName());
			Answer answer6 = new Answer(option3.getName());
			Answer answer7 = new Answer(option17.getName());
			Answer answer8 = new Answer(option15.getName());
			Answer answer9 = new Answer (option18.getName());
			Answer answer10 = new Answer (option19.getName());
			Answer answer11 = new Answer (option21.getName());
			Answer answer12 = new Answer (option21.getName());
			Answer answer13 = new Answer (option23.getName());
			Answer answer14 = new Answer (option24.getName());
			Answer answer15 = new Answer (option27.getName());
			Answer answer16 = new Answer (option25.getName());
			Answer answer17 = new Answer ("Koska se on kivempi");
			Answer answer18 = new Answer ("Vihaan ihmisiä");
			Answer answer19 = new Answer ("Ehkä vähän");
			Answer answer20 = new Answer ("Kyllä");
			Answer answer21 = new Answer ("Aina on parannettavaa");
			Answer answer22 = new Answer ("Kyll");
		
			//Setting answers for questions.
			answer1.setQuestion(question4);
			answer2.setQuestion(question4);
			answer3.setQuestion(question5);
			answer4.setQuestion(question5);
			answer5.setQuestion(question6);
			answer6.setQuestion(question6);
			answer7.setQuestion(question7);
			answer8.setQuestion(question7);
			answer9.setQuestion(question8);
			answer10.setQuestion(question8);
			answer11.setQuestion(question9);
			answer12.setQuestion(question9);
			answer13.setQuestion(question10);
			answer14.setQuestion(question10);
			answer15.setQuestion(question11);
			answer16.setQuestion(question11);
			answer17.setQuestion(question12);
			answer18.setQuestion(question12);
			answer19.setQuestion(question13);
			answer20.setQuestion(question13);
			answer21.setQuestion(question14);
			answer22.setQuestion(question14);
			List<Answer> exampleAnswers = List.of(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, 
					answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20, answer21, answer22);
			answerRepo.saveAll(exampleAnswers);
			
			
			// Logs questions.
			for (Question questionT : testQuestions) {
				log.info(questionT.toString());
			}
			
			for (Question questionE : exampleQuestions) {
				log.info(questionE.toString());
			}
			
		};
	}

}
