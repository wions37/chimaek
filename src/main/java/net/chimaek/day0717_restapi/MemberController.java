package net.chimaek.day0717_restapi;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/members") //맴버와 관련된 .

public class MemberController {

    private List<Member> members = new ArrayList<>();
    private long nextId = 1;

    // GET /api/members // 전체 맴벌를 조회하는 로직
    @GetMapping
    public List<Member> getAllMembers() {
        return members;
    }

    // POST /api/members          // 사용자 생성 로직
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        member.setId(nextId++);
        members.add(member);
        return member;
    }

    // GET /api/members/{id} // 상세 조회
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) { // 아이디로 맵버를 조회한다
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다. Id: " + id));
    }

    // PUT /api/members/{id}  업데이트 (put 전체 수정 patch 일부수정 )
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable("id") Long id, @RequestBody Member updatedMember) {
        Member member = members.stream()  // 맴버 찾기
                .filter(m -> m.getId()==id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다. Id: " + id));

        member.setName(updatedMember.getName());
        member.setEmail(updatedMember.getEmail());
        return member;
    }

    // DELETE /api/members/{id}
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        members.removeIf(member -> member.getId()==id);
    }
}