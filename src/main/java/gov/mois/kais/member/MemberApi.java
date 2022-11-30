package gov.mois.kais.member;

import gov.mois.kais.member.dao.MemberMapper;
import gov.mois.kais.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApi {

    private final MemberMapper memberMapper;

    @GetMapping("")
    public ResponseEntity<List<Member>> members() {
        List<Member> members = memberMapper.findAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/save/dummy")
    public ResponseEntity<Member> addDummyMember() {
        Member member = new Member();
        member.setUsername("test1");
        member.setPassword("1234");
        member.setNickname("test 1");
        memberMapper.save(member);
        return ResponseEntity.ok(member);
    }
}
