package ko.spring.start.practice.answer;

import jakarta.persistence.*;
import ko.spring.start.practice.question.Question;
import ko.spring.start.practice.user.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

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

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifiyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
