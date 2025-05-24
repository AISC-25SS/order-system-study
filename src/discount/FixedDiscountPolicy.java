package discount;

import tempMember.Grade;
import tempMember.Member;

// discount.FixedDiscountPolicy.java
public class FixedDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000; // 고정 할인 1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price - discountFixAmount;
        else
            return price;
    }
}