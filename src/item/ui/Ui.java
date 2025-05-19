package item.ui;
import item.Item;

import java.util.*;

public class Ui {
        private final List<Item> itemList = new ArrayList<>();
        private final Scanner scanner = new Scanner(System.in);
        private long idCounter = 1;

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
                        registerItem();
                        break;
                    case "2":
                        listItems();
                        break;
                    case "0":
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("올바른 메뉴를 선택해주세요.");
                }
            }
        }

        private void registerItem() {
            System.out.println("\n[상품 등록]");
            System.out.print("상품명: ");
            String name = scanner.nextLine();

            int price;
            while (true) {
                System.out.print("가격(원): ");
                String priceInput = scanner.nextLine();
                try {
                    price = Integer.parseInt(priceInput);
                    if (price < 0) {
                        System.out.println("가격은 0원 이상이어야 합니다.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("유효한 숫자를 입력해주세요.");
                }
            }

            Item item = new Item(idCounter++, name, price);
            itemList.add(item);
            System.out.println("상품이 등록되었습니다: " + item);
        }

        private void listItems() {
            System.out.println("\n[전체 상품 목록]");
            if (itemList.isEmpty()) {
                System.out.println("등록된 상품이 없습니다.");
            } else {
                for (Item item : itemList) {
                    System.out.printf("ID: %d | 이름: %s | 가격: %,d원%n",
                            item.getId(), item.getName(), item.getPrice());
                }
            }
        }

}
