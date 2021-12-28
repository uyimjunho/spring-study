package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //private final MemberService memberService = new MemberService(); 여러개를 쓸 필요가 없음
    private final MemberService memberService;

    @Autowired // memberService 와 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
