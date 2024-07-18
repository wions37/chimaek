package net.chimaek.day0716_restApi;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        // 전체 사용자 목록 조회
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // 사용자 생성 로직
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        // 특정 사용자를 찾기.
        return null;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User updateUser){
        // 업데이트 로직
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        // 사용자 삭제 메서드

    }
}