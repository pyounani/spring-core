package pyounani.springCore.discount;

import pyounani.springCore.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
