package ko.spring.start.practice.answer;

import jakarta.persistence.*;
import ko.spring.start.practice.question.Question;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;

    @ManyToOne
    private Question question;

}
