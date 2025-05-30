package order;

import member.Member;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);                  //Order 객체 저장
    List<Order> findAll();                    //모든 Order 조회
    Order findById(Long id);                  // ID로 조회
    boolean updateOrder(Long orderId, int quantity);              // 수정
    boolean deleteOrder(Long orderId);              // 삭제
}
