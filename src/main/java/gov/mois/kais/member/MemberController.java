package gov.mois.kais.member;

import gov.mois.kais.global.api.common.BaseResponseEntity;
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
public class MemberController {

    private final MemberMapper memberMapper;

    @GetMapping("")
    public ResponseEntity<BaseResponseEntity<List<Member>>> members() {
        List<Member> members = memberMapper.findAll();
        return BaseResponseEntity.ok(members);
    }

}
