package order.discount;

import tempMember.Member;

// order.discount.DiscountPolicy.java
public interface DiscountPolicy {
    int discount(Member member, int price);
}
