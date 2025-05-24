package discount;

import tempMember.Grade;
import tempMember.Member;

// RateDiscountPolicy.java
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;// 10% 할인


    public RateDiscountPolicy() {

    }

    @Override
    public int discount(Member member, int price) {
        // price > 100 이라는 가정 하에 구현했습니다
        if (member.getGrade() == Grade.VIP)
            return (int)Math.round(price * (discountPercent /100.0));
        else
            return price;
    }
}
