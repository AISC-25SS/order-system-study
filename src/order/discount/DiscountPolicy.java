package order.discount;

import member.Member;

// order.discount.DiscountPolicy.java
public interface DiscountPolicy {
    int discount(Member member, int price);
}
