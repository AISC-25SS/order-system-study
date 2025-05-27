package order;

import java.util.List;

public interface OrderService { //계산서 조회 인터페이스

    Order registerOrder(Order order); //Order 객체 등록
    void ListOrders(); 	//모든 Order객체 열거
    List<Order> getALLOrders(); //모든 Order 객체 열거
    List<Order> getOrder(Long orderId); //Order객체 찾기
    boolean updateOrder(Order order); //업데이트가 됐다면 true, 없으면 false 리턴
    boolean deleteOrder(Order order); //삭제가 됐다면 true, 없으면 false 리턴
    boolean isEmpty();
}