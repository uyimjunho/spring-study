package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//Optional : Null 처리위함
    Optional<Member> findByName(String name);
    List<Member> findAll();



}




