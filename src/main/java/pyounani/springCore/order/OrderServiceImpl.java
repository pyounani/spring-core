package pyounani.springCore.order;

import pyounani.springCore.discount.DiscountPolicy;
import pyounani.springCore.discount.FixDiscountPolicy;
import pyounani.springCore.member.Member;
import pyounani.springCore.member.MemberRepository;
import pyounani.springCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
