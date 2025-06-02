package order.discount;

import member.Grade;
import member.Member;

// RateDiscountPolicy.java
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;// 10% 할인


    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP)
            return (int)Math.round(price * (discountPercent /100.0));
        else
            return 0;
    }
}
