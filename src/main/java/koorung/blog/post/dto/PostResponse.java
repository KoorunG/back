package koorung.blog.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * PackageName : koorung.blog.post.dto
 * FileName : PostResponse
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */

@Getter
@Builder
@RequiredArgsConstructor
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;

}
