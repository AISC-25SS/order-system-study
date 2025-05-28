package order;

import java.util.*;


public class OrderUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderService service;

    public OrderUI(OrderService service) {
        this.service = service;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== 주문 관리 시스템 ===");
            System.out.println("1. 주문하기");
            System.out.println("2. 주문 번호로 조회하기");
            System.out.println("3. 주문 정보 수정하기");
            System.out.println("4. 주문 취소하기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            //scanner.nextLine();

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    createOrder();
                    break;

                case "2":
                    System.out.println("주문 번호를 입력하세요: ");
                    Long orderNum = scanner.nextLong();
                    // OrderService의 getOrder가 주문id를 활용해야 될 거 같은데 아닌가요
                    List<Order> myOrders = service.getOrder(orderNum);
                    for (Order order : myOrders)
                        System.out.println(order);
                    break;
                case "3":
                    updateOrder();
                    break;
                case "4":
                    deleteOrder();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private void createOrder() {
        //Order 객체 생성에 필요한 데이터를 임시 저장하는 지역변수들
        Long memberId = 0L;
        Long itemId = 0L;
        int quantity = 0;
        int itemPrice = 0;
        int totalPrice;
        int discountPrice = 0;
        int fixedDiscountPrice;
        int rateDiscountPrice;
        int finalPrice = 0;
        Member member = null;
        Item item;
        Order newOrder;

        //회원 정보 및 회원 객체 저장
        try {
            System.out.println("회원 ID를 입력하세요: ");
            memberId = scanner.nextLong();
            member = service.getMemberService().findById(memberId);
        } catch (NumberFormatException e) {
            System.out.println("올바른 회원 ID를 입력해주세요.");
        }

        //상품 정보 및 상품 객체 저장
        try {
            System.out.print("상품 ID를 입력하세요:  ");
            itemId = scanner.nextLong();
            item = service.getItemService().getItem(itemId);
            itemPrice = item.getPrice();
        } catch(NumberFormatException e) {
            System.out.println("올바른 상품 ID를 입력해주세요.");
        }


        //주문 수량 입력 (간단한 예외처리)
        while (quantity <= 0) {
            System.out.print("주문 수량을 입력하세요: ");
            quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("올바른 수량을 입력해주세요");
            }
        }
        totalPrice = itemPrice * quantity;

        //할인 금액 계산 및 할인 방식 입력
        try {
            fixedDiscountPrice = service.getFixedDiscountPolicy().discount(member, totalPrice);
            rateDiscountPrice = service.getRateDiscountPolicy().discount(member, totalPrice);
            System.out.println("1. 고정 할인가 적용 금액: " + fixedDiscountPrice);
            System.out.println("2. 고정 할인율 적용 금액: " + rateDiscountPrice);
            System.out.println("할인 적용 방식을 선택하세요: ");
            int selectDiscount = scanner.nextInt();

            if (selectDiscount == 1) {
                finalPrice = totalPrice - fixedDiscountPrice;
                discountPrice = fixedDiscountPrice;
            } else if (selectDiscount == 2) {
                finalPrice = totalPrice - rateDiscountPrice;
                discountPrice = rateDiscountPrice;
            } else {
                System.out.println("올바른 입력이 아닙니다");
                return;
            }
        } catch(NumberFormatException e) {
            System.out.println("올바른 입력이 아닙니다.");
        }


        //주문 정보 확인창
        System.out.println("[주문 정보 확인]");
        System.out.println("회원ID: " + memberId);
        System.out.println("상품ID: " + itemId);
        System.out.println("수량: " + quantity);
        System.out.println("상품 가격: " + itemPrice);
        System.out.println("할인 금액: " + discountPrice);
        System.out.println(", 결제 금액: " + finalPrice);
        System.out.println("---------------------------");

        try {
            System.out.println("상품을 주문하시겠습니까? (예: 1, 아니오: 0): ");
            int selectOrder = scanner.nextInt();
            if (selectOrder == 1) {
                newOrder = new Order(memberId, itemId, itemPrice, discountPrice, finalPrice, quantity, 0L);
                service.registerOrder(newOrder);
                System.out.println("주문이 완료되었습니다");
            }

            else if (selectOrder == 0) {
                System.out.println("주문이 중단되었습니다");
                return;
            }

            else {
                System.out.println("올바른 입력이 아닙니다.");
                return;
            }
        } catch(NumberFormatException e) {
            System.out.println("올바른 입력이 아닙니다.");
        }
    }

//    private void updateOrder() {
//
//        System.out.println("\n=== 주문 수정 ===");
//        service.ListOrders(); // 현재 주문 목록 표시
//        Long memberId;
//        Long itemId;
//        int quantity = 0;
//        int itemPrice = 0;
//        int totalPrice;
//        int discountPrice = 0;
//        int fixedDiscountPrice;
//        int rateDiscountPrice;
//        int finalPrice = 0;
//        Member member = null;
//        Item item;
//        Order newOrder;
//
//        System.out.print("수정할 주문의 ID를 입력하세요: ");
//        try {
//            Long id = Long.parseLong(scanner.nextLine());
//            List<Order> orders = service.getOrder(id);
//            //특정 Order 객체 하나만 받아오는 게 지금으로서는 불가능함
//            if (orders.isEmpty()) {
//                System.out.println("해당 ID의 주문이 존재하지 않습니다.");
//                return;
//            }
//            //제대로 작동하는지 로직 확인 필요
//            for (Order order : orders) {
//                memberId = order.getMemberId();
//                //Order.toString() 활용 출력
//                System.out.println("현재 주문 정보: " + order);
//                System.out.print("새로운 상품 ID를 입력하세요(변경하지 않으려면 엔터): ");
//                itemId = scanner.nextLong();
//                if (itemId.equals(order.getItemId())) {
//                    itemPrice = order.getItemPrice();
//                }
//                else {
//                    item = service.getItemService().getItem(itemId);
//                    itemPrice = item.getPrice();
//                }
//
//                System.out.print("주문 수량을 입력하세요(변경하지 않으려면 엔터): ");
//                quantity = scanner.nextInt();
//                int price = priceStr.isEmpty() ? order.getPrice() : Integer.parseInt(priceStr);
//
//                boolean success = service.updateItem(id, name, price);
//
//                if (success) {
//                    System.out.println("상품이 성공적으로 수정되었습니다.");
//                }
//                else {
//                    System.out.println("상품 수정에 실패했습니다.");
//                }
//            }
//        } catch(NumberFormatException e) {
//                System.out.println("올바른 숫자 형식을 입력해주세요.");
//        }
//    }

    private void deleteOrder() {
        System.out.println("\n=== 주문 취소 ===");
        service.ListOrders(); // 현재 상품 목록 표시

        System.out.print("삭제할 주문의 ID를 입력하세요: ");
        try {
            Long id = Long.parseLong(scanner.nextLine());
            //특정 Order 객체 하나만 받아오는 게 지금으로서는 불가능함
            List<Order> orders = service.getOrder(id);
            //제대로 작동하는지 로직 확인 필요
            boolean success = false;
            for (Order order : orders)
                success = service.deleteOrder(order);

            if (success) {
                System.out.println("주문이 성공적으로 취소되었습니다.");
            } else {
                System.out.println("해당 ID의 주문이 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자 형식을 입력해주세요.");
        }
    }
}
}
