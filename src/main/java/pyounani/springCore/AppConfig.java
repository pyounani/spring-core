package pyounani.springCore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pyounani.springCore.discount.DiscountPolicy;
import pyounani.springCore.discount.RateDiscountPolicy;
import pyounani.springCore.member.MemberRepository;
import pyounani.springCore.member.MemberService;
import pyounani.springCore.member.MemberServiceImpl;
import pyounani.springCore.member.MemoryMemberRepository;
import pyounani.springCore.order.OrderService;
import pyounani.springCore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
