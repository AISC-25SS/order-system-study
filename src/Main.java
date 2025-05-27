

import java.util.*;
import order.Order;

// 자 다른 패키지에 있는 order를 이 메인에서 사용하기 위해 import.order.order로 사용할 수 있게 한다.

public class Main {
    public static void main(String[] args) {

        long memberId;
        long itemId;
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


    }
}

