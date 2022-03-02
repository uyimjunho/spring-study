package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.lang.model.SourceVersion;

@Component
public class OrderServiceImpl implements OrderService {

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
//        System.out.println("discount : " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println(memberRepository);
        this.memberRepository = memberRepository;
    }

    //    @Autowired // 생성자 하나일때는 생략해도 됨
    /*
     * 생성자 주입
     * 생성자 호출시점에 딱 1번만 호출되는 것이 보장됨.
     * 불변, 필수 의존관계에서 씀
     */

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("memberRepository = " + memberRepository);
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
