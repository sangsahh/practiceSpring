package ko.spring.start.practice;

import ko.spring.start.practice.answer.Answer;
import ko.spring.start.practice.answer.AnswerRepository;
import ko.spring.start.practice.question.Question;
import ko.spring.start.practice.question.QuestionRepository;
import ko.spring.start.practice.question.QuestionService;
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
	private QuestionService questionService;

	@Autowired
	private AnswerRepository answerRepository;


	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content, null);
		}
	}



	@Test
	void contextLoads() {
	}

}
