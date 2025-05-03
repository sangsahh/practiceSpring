package ko.spring.start.practice;

import ko.spring.start.practice.answer.Answer;
import ko.spring.start.practice.answer.AnswerRepository;
import ko.spring.start.practice.question.Question;
import ko.spring.start.practice.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PracticeApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreatedDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}



	@Test
	void contextLoads() {
	}

}
