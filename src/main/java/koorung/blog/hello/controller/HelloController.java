package koorung.blog.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PackageName : koorung.blog.hello.controller
 * FileName : HelloController
 * Author : Koorung
 * Date : 2023년 05월 06일
 * Description :
 */

@RestController
@CrossOrigin
public class HelloController {

    @Value("${blog.name}")
    private String BLOG_NAME;

    @GetMapping("/hello")
    public String hello() {
        return "Running on ::: " + BLOG_NAME;
    }
}
