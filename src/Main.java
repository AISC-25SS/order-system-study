import java.util.*;
import discount.FixedDiscountPolicy;
import discount.RateDiscountPolicy;
import tempMember.Grade;
import tempMember.Member;


public class Main {
    public static void main(String[] args){

        int discount;
        int price;
        Scanner sc = new Scanner(System.in);
        price = sc.nextInt();


        Member member1 = new Member(1L, "bin", "qwer1234","종빈", Grade.VIP);

        RateDiscountPolicy totalPrice= new RateDiscountPolicy();
        discount = totalPrice.discount(member1, price);
        System.out.println("할인된 가격:" + discount);



    }
}
