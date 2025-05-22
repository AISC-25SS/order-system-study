import tempMember.Grade;
import tempMember.Member;

// FixedDiscountPolicy.java
public class FixedDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000; // 고정 할인 1000원

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price - 1000;
        else
            return price;// <- 여기서 member의 getGrade 를 통해서 구현가능
    }
}