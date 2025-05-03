package ko.spring.start.practice.question;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
//    @ResponseBody
    public String list(Model model) {
        List<Question> list = this.questionRepository.findAll();
        System.out.println("질문 개수: " + list.size());
        model.addAttribute("questionList", list);
        return "question_list";

    }
}
