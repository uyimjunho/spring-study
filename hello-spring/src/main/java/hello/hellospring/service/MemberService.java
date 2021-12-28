package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //컨테이너에 등록
public class MemberService {//cmd + shift + t : testcode 생성

    private final MemberRepository memberrepository;

    @Autowired
    public MemberService(MemberRepository memberrepository) {
        this.memberrepository = memberrepository;
    }


    /**
     * 회원가입   cmd + x : line 삭제
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 안됨.
        checkDuplicated(member);
        //cmd + opt + v = 변수추출

        memberrepository.save(member);
        return member.getId();
    }

    private void checkDuplicated(Member member) {
        memberrepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원");
        });
    }

    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberrepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberrepository.findById(memberId);
    }
}
