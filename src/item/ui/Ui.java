package item.ui;

import item.ItemService;

import java.util.*;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);
    private final ItemService service;

    public Ui(ItemService service) {
        this.service = service;
    }

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
                    System.out.print("상품명을 입력하세요:  ");
                    String itemName = scanner.nextLine();
                    System.out.print("상품 가격을 입력하세요: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    service.registerItem(itemName, price);
                    break;
                case "2":
                    service.listItems();
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


