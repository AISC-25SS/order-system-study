package order.discount;

import tempMember.Grade;
import tempMember.Member;

// order.discount.FixedDiscountPolicy.java
public class FixedDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000; // 고정 할인 1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return discountFixAmount;
        else
            return 0;
    }
}