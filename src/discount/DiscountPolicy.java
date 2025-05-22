package discount;

import tempMember.Member;

// discount.DiscountPolicy.java
public interface DiscountPolicy {
    int discount(Member member, int price);
}
