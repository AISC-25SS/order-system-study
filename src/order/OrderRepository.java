package order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);                  // 저장
    List<Order> findAll();                    // 전체 조회
    Order findById(Long id);                  // ID로 조회
    boolean update(Order order);              // 수정
    boolean delete(Order order);              // 삭제
}
