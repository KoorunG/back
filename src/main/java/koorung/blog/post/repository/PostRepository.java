package koorung.blog.post.repository;

import koorung.blog.post.domain.Post;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : koorung.blog.post.repository
 * FileName : PostRepository
 * Author : Koorung
 * Date : 2023년 05월 07일
 * Description :
 */
public interface PostRepository extends Repository<Post, Long> {
    // 모든 글 조회
    List<Post> findAll();

    // 식별자로 단일 글 조회
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);

    // 저장
    void save(Post post);

    // 삭제
    void deletePostById(Long id);
}
