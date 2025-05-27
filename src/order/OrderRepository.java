package order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);                  //Order 객체 저장
    List<Order> findAll();                    //모든 Order 조회
    Order findById(Long id);                  // ID로 조회
    boolean update(Order order);              // 수정
    boolean delete(Order order);              // 삭제
}
