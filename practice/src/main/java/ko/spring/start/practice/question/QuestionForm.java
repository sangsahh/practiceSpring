package ko.spring.start.practice.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
