package hh.survey.Survey.domain;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	Question findByName(String name);

}
