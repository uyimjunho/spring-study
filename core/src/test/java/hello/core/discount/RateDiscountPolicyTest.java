package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP = 10% discount")
    void vip_o() {
        //given
        Member member = new Member(1L, "vip", Grade.VIP);

                //when
        int discount = discountPolicy.discount(member, 10000);

                // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

}