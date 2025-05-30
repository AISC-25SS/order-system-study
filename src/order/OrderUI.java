package order;

import item.Item;
import member.Member;

import java.util.*;


public class OrderUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService service;


    public OrderUI(OrderService service) {
        this.service = service;
    }

    public void run(Member loginMember) {
        if (loginMember == null) {
            System.out.println("로그아웃 상태입니다.");
            return;
        }

        while (true) {
            System.out.println("\n=== 주문 관리 시스템 ===");
            System.out.println("1. 상품 목록 보기");
            System.out.println("2. 주문하기");
            System.out.println("3. 주문 조회하기");
            System.out.println("4. 주문 취소하기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");


            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    List<Item> itemList = service.displayItem();
                    for (Item item : itemList)
                        System.out.println(item);

                    break;

                case "2":
                    createOrder(loginMember.getMemberId());
                    break;

                case "3":
                    try {
                        findOrder(loginMember.getMemberId());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "4":
                    try {
                        deleteOrder();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private void createOrder(Long memberId) {

        Long itemId = 0L;
        int quantity = 0;

        //상품 정보 및 상품 객체 저장
        try {
            System.out.print("상품 ID를 입력하세요:  ");
            itemId = scanner.nextLong();
            scanner.nextLine();
            service.isValidateItemById(itemId);

        } catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        //주문 수량 입력 (간단한 예외처리)
        while (quantity <= 0) {
            System.out.print("주문 수량을 입력하세요: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity <= 0) {
                System.out.println("올바른 수량을 입력해주세요");
            }
        }

        service.registerOrder(memberId, itemId, quantity);
    }

    private void findOrder(Long memberId) {
        List<Order> orderList = service.getALLOrders(memberId);
        if (orderList.isEmpty())
            throw new NoSuchElementException("주문 내역이 없습니다");
        for (Order order : orderList)
            System.out.println(order);
    }

    private void deleteOrder() {
        Long orderId = 0L;
        try {
        System.out.print("취소할 주문의 번호를 입력하세요: ");
        orderId = scanner.nextLong();
        scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("올바른 주문 ID를 입력해주세요.");
        }

        if (!service.delete(orderId)) {
            throw new IllegalArgumentException("유효하지 않은 요청입니다");
        }
    }
}