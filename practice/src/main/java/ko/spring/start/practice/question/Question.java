package ko.spring.start.practice.question;

import jakarta.persistence.*;
import ko.spring.start.practice.answer.Answer;
import ko.spring.start.practice.user.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifiyDate;

    @ManyToMany
//   List 보다 Set을 쓰는 이유 : voter 속성값이 서로 중복되지 않도록 하기 위해서
    Set<SiteUser> voter;
}
