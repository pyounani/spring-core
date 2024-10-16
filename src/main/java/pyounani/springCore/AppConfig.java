package pyounani.springCore;

import pyounani.springCore.discount.RateDiscountPolicy;
import pyounani.springCore.member.MemberService;
import pyounani.springCore.member.MemberServiceImpl;
import pyounani.springCore.member.MemoryMemberRepository;
import pyounani.springCore.order.OrderService;
import pyounani.springCore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy());
    }

}
