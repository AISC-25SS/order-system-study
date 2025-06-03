package main;

import config.AppConfig;
import item.ItemUI;
import member.MemberUI;
import order.OrderUI;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberUI memberUI = appConfig.memberUI();
        ItemUI itemUI = appConfig.itemUI();
        OrderUI orderUI = appConfig.orderUI();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 주문 시스템 ===");
            System.out.println("1. 회원 기능");
            System.out.println("2. 상품 기능");
            System.out.println("3. 주문 기능");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> memberUI.run();
                case "2" -> itemUI.run();
                case "3" -> orderUI.run(memberUI.getCurrentMember());
                case "0" -> {
                    System.out.println("시스템을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }

    }
}

