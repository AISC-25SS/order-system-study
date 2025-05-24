import java.util.*;
import order.Order;

// 자 다른 패키지에 있는 order를 이 메인에서 사용하기 위해 import.order.order로 사용할 수 있게 한다.

public class Main {
    public static void main(String[] args){

        Long memberId;
        Long itemId;
        int quantity;
        int itemPrice;
        int discountPrice;
        int finalPrice;



        Scanner sc = new Scanner(System.in);
        memberId = sc.nextLong();
        itemId = sc.nextLong();
        quantity = sc.nextInt();
        itemPrice = sc.nextInt();
        discountPrice = sc.nextInt();
        finalPrice = sc.nextInt();



        Order order = new Order(memberId,itemId,itemPrice, discountPrice, finalPrice, quantity);
        System.out.println("멤버아이디 :" + order.getMemberId());
        System.out.println("상품명 :" + order.getItemId());
        System.out.println("수량 :" + order.getQuantity());
        System.out.println("가격 :" + order.getItemPrice());
        System.out.println("할인가격 :" + order.getDiscountPrice());
        System.out.println("총 금액 :" + order.getFinalPrice());


    }
}
