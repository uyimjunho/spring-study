package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepo;

    @BeforeEach
    public void beforeEach(){
        memberRepo = new MemoryMemberRepository();
        memberService = new MemberService(memberRepo);
    }

    @AfterEach
    public void afterEach(){
        memberRepo.clearStore();
    }
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

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}