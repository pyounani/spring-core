package pyounani.springCore;

import pyounani.springCore.discount.DiscountPolicy;
import pyounani.springCore.discount.RateDiscountPolicy;
import pyounani.springCore.member.MemberRepository;
import pyounani.springCore.member.MemberService;
import pyounani.springCore.member.MemberServiceImpl;
import pyounani.springCore.member.MemoryMemberRepository;
import pyounani.springCore.order.OrderService;
import pyounani.springCore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
