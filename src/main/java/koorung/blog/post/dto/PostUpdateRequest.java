package koorung.blog.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName : koorung.blog.post.dto
 * FileName : PostSaveRequest
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */
@Getter
@NoArgsConstructor
public class PostUpdateRequest {

    private Long id;
    private String title;
    private String content;

}