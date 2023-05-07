package koorung.blog.post.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import koorung.blog.post.domain.Post;
import koorung.blog.post.dto.PostSaveRequest;
import koorung.blog.post.dto.PostUpdateRequest;
import koorung.blog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : koorung.blog.posts.service
 * FileName : PostService
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public void savePost(PostSaveRequest request) {
        postRepository.save(request.toEntity());
    }

    @Transactional
    public Post updatePost(PostUpdateRequest request) {
        Long id = request.getId();
        Post target = postRepository.findById(id).orElseThrow();

        // 변경감지
        target.update(request.getTitle(), request.getContent());

        return target;
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deletePostById(id);
    }


    @PostConstruct
    public void init() {
        for(int i = 1; i <= 5; i++) {
            Post created = PostSaveRequest.builder()
                    .title("예제 제목" + i)
                    .content("예제 내용"+ i)
                    .build()
                    .toEntity();

            // 초기 데이터는 값이 없을 경우에만 삽입
            if(postRepository.findByTitle(created.getTitle()).isEmpty()) {
                postRepository.save(created);
            }
        }
    }
}
