package item;

import java.util.*;

public class ItemUI {
    private final Scanner scanner = new Scanner(System.in);
    private final ItemService service;

    public ItemUI(ItemService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== 상품 관리 시스템 ===");
            System.out.println("1. 상품 등록");
            System.out.println("2. 전체 상품 조회");
            System.out.println("3. 상품 수정");
            System.out.println("4. 상품 삭제");
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
                case "3":
                    updateItem();
                    break;
                case "4":
                    deleteItem();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private void updateItem() {
        System.out.println("\n=== 상품 수정 ===");
        service.listItems(); // 현재 상품 목록 표시

        System.out.print("수정할 상품의 ID를 입력하세요: ");
        try {
            Long id = Long.parseLong(scanner.nextLine());
            Item item = service.getItem(id);

            if (item == null) {
                System.out.println("해당 ID의 상품이 존재하지 않습니다.");
                return;
            }

            System.out.println("현재 상품 정보: " + item);
            System.out.print("새 상품명을 입력하세요(변경하지 않으려면 엔터): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                name = item.getName();
            }

            System.out.print("새 가격을 입력하세요(변경하지 않으려면 엔터): ");
            String priceStr = scanner.nextLine();
            int price = priceStr.isEmpty() ? item.getPrice() : Integer.parseInt(priceStr);

            boolean success = service.updateItem(id, name, price);
            if (success) {
                System.out.println("상품이 성공적으로 수정되었습니다.");
            } else {
                System.out.println("상품 수정에 실패했습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자 형식을 입력해주세요.");
        }
    }

    private void deleteItem() {
        System.out.println("\n=== 상품 삭제 ===");
        service.listItems(); // 현재 상품 목록 표시

        System.out.print("삭제할 상품의 ID를 입력하세요: ");
        try {
            Long id = Long.parseLong(scanner.nextLine());
            boolean success = service.deleteItem(id);

            if (success) {
                System.out.println("상품이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 ID의 상품이 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자 형식을 입력해주세요.");
        }
    }
}
