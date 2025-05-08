package ko.spring.start.practice.question;


import jakarta.validation.Valid;
import ko.spring.start.practice.answer.AnswerForm;
import ko.spring.start.practice.user.SiteUser;
import ko.spring.start.practice.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;


    //paging 구현
    @GetMapping("/list")
//    @ResponseBody
    public String list(Model model,@RequestParam(value="page", defaultValue = "0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id
        );
        model.addAttribute("question", question);
        model.addAttribute("answerForm", new AnswerForm());
        return "question_detail";
    }

    //@PreAuthorize("isAuthenticated()")는 로그인 상태에서만 할수 있도록 만드는것
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value= "/create")
    public String questionCreate(Model model) {
        model.addAttribute("questionForm", new QuestionForm());
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult
    , Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list"; //질문 저장후 질문목록으로 이동
    }

}
