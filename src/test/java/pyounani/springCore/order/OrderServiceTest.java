package pyounani.springCore.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pyounani.springCore.member.Grade;
import pyounani.springCore.member.Member;
import pyounani.springCore.member.MemberService;
import pyounani.springCore.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}

