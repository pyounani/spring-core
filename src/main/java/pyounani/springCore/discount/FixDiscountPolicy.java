package pyounani.springCore.discount;

import pyounani.springCore.member.Grade;
import pyounani.springCore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAccount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAccount;
        } else {
            return 0;
        }
    }
}
