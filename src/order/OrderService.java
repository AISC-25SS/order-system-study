package order;

import java.util.List;

public interface OrderService {

    //Order 객체 등록
    Order registerOrder(Long memberId, Long itemId, int quantity);
    //모든 Order 객체 열거
    List<Order> getALLOrders();

    //Order객체 찾기
    Order getOrder(Long memberId);

    //업데이트가 됐다면 true, 없으면 false 리턴
    boolean update(Long orderId, int quantity);

    //삭제가 됐다면 true, 없으면 false 리턴
    boolean delete(Long orderId);

}
