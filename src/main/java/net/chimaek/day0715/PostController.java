package net.chimaek.day0715;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private List<Post> posts = new ArrayList<>();
    private Long nextId = 1L; //숫자가 쌓일때 1씩 증가한다

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/form";
    }

    @PostMapping
    public String savePost(@ModelAttribute Post post) {
        post.setId(nextId++);
        post.setCreateAt(LocalDateTime.now());
        posts.add(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        model.addAttribute("post", post);
        return "post/detail";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        posts.removeIf(post -> post.getId() == id);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        model.addAttribute("post", post);
        return "post/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, @ModelAttribute Post updatedPost) {
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        post.setTitle(updatedPost.getTitle()); // set메서드로 업데이트 객체의 title 값으로 변경
        post.setContent(updatedPost.getContent());// set 메서드로 엡데이터ㅡ 객체의 content 값으로 변경
        return "redirect:/posts/{id}";
    }
}
