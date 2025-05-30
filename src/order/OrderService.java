package order;

import java.util.List;

import item.Item;
import member.Member;

public interface OrderService {

    //Order 객체 등록
    Order registerOrder(Long memberId, Long itemId, int quantity);
    //모든 Order 객체 열거
    List<Order> getALLOrders(Long memberId);

    //뭔지모름
    Order getOrder(Long id);

    //업데이트가 됐다면 true, 없으면 false 리턴
    boolean update(Long orderId, int quantity);

    //삭제가 됐다면 true, 없으면 false 리턴
    boolean delete(Long orderId);

    List<Item> displayItem();

    void isValidateItemById(Long itemId);

}
