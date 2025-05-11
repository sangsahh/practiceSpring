package ko.spring.start.practice.question;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll (Pageable pageable);
    Page<Question> findAll (Specification<Question> spec, Pageable pageable);

    //자바 코드로 쿼리를 생성하는 방식보다 직접 쿼리를 작성하는게 편할때
    @Query("select "
            + "distinct q"
            +"from Question q"
            +"left outer join SiteUser u1 on q.author=u1"
            +"left outer join Answer a on a.question=q"
            +"left outer join SiteUser u2 on a.author=u2"
            +"where"
            +"      q.subject like %:kw% "
            +"      or q.content like %:kw% "
            +"      or u1.content like %:kw% "
            +"      or a.content like %:kw% "
            +"      or u2.content like %:kw% ")
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
