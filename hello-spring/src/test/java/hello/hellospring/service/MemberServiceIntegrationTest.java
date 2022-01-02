package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //테스트하고 롤백해줌
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepo;

    @Test
    void join() {
       //given
        Member member = new Member();
        member.setName("juno");

       //when
       Long Id = memberService.join(member);
       //then
        Member findMember = memberService.findOne(Id).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    void dupl_join(){
        //given
        Member member = new Member();
        member.setName("juno");

        Member member1 = new Member();
        member1.setName("juno");
        //when
        memberService.join(member);
        assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        //then

    }
//
//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
}