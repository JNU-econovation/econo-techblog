package blog.econovation.tcono.domain.post;

import jdk.jfr.Category;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String content;

    private Boolean official;

    private String title;

    private Category category;
}
