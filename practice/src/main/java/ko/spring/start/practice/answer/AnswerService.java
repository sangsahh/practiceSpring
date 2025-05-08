package ko.spring.start.practice.answer;


import ko.spring.start.practice.question.Question;
import ko.spring.start.practice.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreatedDate(LocalDateTime.now());
        answer.setAuthor(author);
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }

}
