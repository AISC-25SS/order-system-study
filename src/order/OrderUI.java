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
                        deleteOrder(loginMember.getMemberId());
                    } catch (RuntimeException e) {
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

        Long itemId;
        int quantity;

        //상품 정보 및 상품 객체 저장
        try {
            System.out.print("상품 ID를 입력하세요:  ");
            itemId = scanner.nextLong();
            scanner.nextLine();
            service.isValidateItemById(itemId);

        } catch (InputMismatchException e) {
            System.out.println("잘못된 형식의 입력입니다");
            scanner.nextLine();
            return;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        //주문 수량 입력 (간단한 예외처리)
        try {
            System.out.print("주문 수량을 입력하세요: ");
            quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity <= 0)
                throw new IllegalArgumentException("올바른 수량을 입력해주세요");

        } catch (InputMismatchException e) {
            System.out.println("잘못된 형식의 입력입니다");
            scanner.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
//        while (quantity <= 0) {
//            System.out.print("주문 수량을 입력하세요: ");
//            quantity = scanner.nextInt();
//            scanner.nextLine();
//            if (quantity <= 0) {
//                System.out.println("올바른 수량을 입력해주세요");
//            }
//        }

        // 주문 확인 출력용
        Order newOrder = service.registerOrder(memberId, itemId, quantity);
        if (newOrder == null)
            System.out.println("[오류] 주문에 실패하였습니다. 다시 시도해 주세요.");
        else
            System.out.println("[주문 완료]: " + newOrder);
    }

    private void findOrder(Long memberId) {
        List<Order> orderList = service.getALLOrders(memberId);
        if (orderList.isEmpty())
            throw new NoSuchElementException("주문 내역이 없습니다");
        for (Order order : orderList)
            System.out.println(order);
    }

    private void deleteOrder(Long memberId) {
        try {
            findOrder(memberId);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("취소할 주문의 번호를 입력하세요: ");
        String input = scanner.next();

        // 사전 검증: 정규 표현식을 사용하여 입력값이 양의 정수로 구성되어 있는지 확인
        if (!input.matches("\\d+")) {
            System.out.println("잘못된 형식의 입력입니다.");
            return;
        }

        long orderId;
        try {
            orderId = Long.parseLong(input); // 사전 검증 덕분에 여기서는 예외 발생 가능성이 낮지만,
                                             // 혹시 모를 상황에 대비해 예외 처리를 함
            if (orderId <= 0) { // 추가 논리 검증
                throw new IllegalArgumentException("올바른 주문 번호를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 형식의 입력입니다.");
            return;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (!service.delete(orderId)) {
            throw new RuntimeException("삭제 요청이 정상적으로 처리되지 않았습니다. 다시 시도해 주세요");
        }
    }
}