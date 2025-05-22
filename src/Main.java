import java.util.*;
import order.Order;

// 자 다른 패키지에 있는 order를 이 메인에서 사용하기 위해 import.order.order로 사용할 수 있게 한다.

public class Main {
    public static void main(String[] args){

        Long memberId;
        String itemName;

        Scanner sc = new Scanner(System.in);
        memberId = sc.nextLong();
        itemName = sc.next();

        Order order = new Order(memberId,itemName);
        System.out.println("멤버아이디 :" + order.getMemberId());
        System.out.println("상품명 :" + order.getItemName());


    }
}
