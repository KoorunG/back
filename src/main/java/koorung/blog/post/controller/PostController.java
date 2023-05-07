package koorung.blog.post.controller;

import koorung.blog.post.domain.Post;
import koorung.blog.post.dto.PostResponse;
import koorung.blog.post.dto.PostSaveRequest;
import koorung.blog.post.dto.PostUpdateRequest;
import koorung.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PackageName : koorung.blog.posts.controller
 * FileName : PostController
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@CrossOrigin()
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping()
    public List<PostResponse> getPosts() {
        return postService.getPosts()
                .stream()
                .map(Post::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public void savePost(@RequestBody PostSaveRequest request) {
        log.info("request ::: {}", request);
        log.info("request.getTitle() ::: {}", request.getTitle());
        log.info("request.getContent() ::: {}", request.getContent());
        postService.savePost(request);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id){
        return postService.getPostById(id).orElseThrow().toResponse();
    }

    @PatchMapping("/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest request) {
        return postService.updatePost(request).toResponse();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
