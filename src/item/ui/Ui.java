package item.ui;

import java.util.*;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== 상품 관리 시스템 ===");
            System.out.println("1. 상품 등록");
            System.out.println("2. 전체 상품 조회");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    //registerItem();
                    break;
                case "2":
                    //listItems();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }
}


