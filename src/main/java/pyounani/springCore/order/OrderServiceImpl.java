package pyounani.springCore.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pyounani.springCore.discount.DiscountPolicy;
import pyounani.springCore.member.Member;
import pyounani.springCore.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
