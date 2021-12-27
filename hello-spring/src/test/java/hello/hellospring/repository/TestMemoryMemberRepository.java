package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class TestMemoryMemberRepository {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){//하나의 테스트 끝날때마다 repo지워줌
        repo.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("juno");
        repo.save(member);
        Member result = repo.findById(member.getId()).get();//.get() = optional 에서 값꺼낼떄


        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member2 = new Member();// fn + shift + f6 : rename
        member2.setName("jjuno");
        repo.save(member2);

        Member member1 = new Member();// fn + shift + f6 : rename
        member1.setName("jie");
        repo.save(member1);

        Member result = repo.findByName("jie").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member2 = new Member();// fn + shift + f6 : rename
        member2.setName("jjuno");
        repo.save(member2);

        Member member1 = new Member();// fn + shift + f6 : rename
        member1.setName("jie");
        repo.save(member1);

        List<Member> result = repo.findAll();

        assertThat(result.size()).isEqualTo(2);
    }




}
