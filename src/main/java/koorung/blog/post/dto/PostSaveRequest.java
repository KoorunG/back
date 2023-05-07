package koorung.blog.post.dto;

import koorung.blog.post.domain.Post;
import lombok.*;

/**
 * PackageName : koorung.blog.post.dto
 * FileName : PostSaveRequest
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor
public class PostSaveRequest {

    private String title;
    private String content;
    public PostSaveRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return new Post(getTitle(), getContent());
    }
}