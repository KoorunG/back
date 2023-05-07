package koorung.blog.post.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import koorung.blog.post.dto.PostResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName : koorung.blog.post.domain
 * FileName : Post
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */

@Valid
@Entity
@Getter
@NoArgsConstructor
public class Post {

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @Lob
    @NotEmpty
    private String content;

    public PostResponse toResponse() {
        return PostResponse.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
