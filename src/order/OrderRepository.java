package order;

import member.Member;

import java.util.List;

public interface OrderRepository {
    Order save(Order order, Long quantity);                  //Order 객체 저장
    List<Order> findMemberOrderedAll(Long memberId);         //모든 Order 조회
    Order findById(Long id);                                 // ID로 조회
    boolean update(Long orderId, int quantity);              // 수정
    boolean delete(Long orderId);                            // 삭제
}
