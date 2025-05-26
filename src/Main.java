import java.util.*;

import order.discount.FixedDiscountPolicy;
import order.discount.RateDiscountPolicy;
import tempMember.Grade;
import tempMember.Member;


public class Main {
    public static void main(String[] args){

        int fixedDiscountPrice;
        int rateDiscountPrice;
        int price = 0;
        Scanner sc = new Scanner(System.in);

        Member member = new Member(1L, "bin", "qwer1234","종빈", Grade.VIP);

        System.out.print("상품 가격을 입력하세요: ");

        try {
            price = sc.nextInt();
        } catch (Exception e) {
            System.out.println("입력이 올바르지 않습니다");
        }

        FixedDiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy();
        fixedDiscountPrice = fixedDiscountPolicy.discount(member, price);


        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
        rateDiscountPrice = rateDiscountPolicy.discount(member, price);

        System.out.println("VIP 회원인 경우에만 할인이 적용됩니다");
        System.out.println("고정가격 할인금액: " + fixedDiscountPrice);
        System.out.println("고정비율 할인금액: " + rateDiscountPrice);
    }
}
