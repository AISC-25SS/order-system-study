package order;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class MemoryOrderRepository implements OrderRepository {

    //(memberId, List<order객체>) 저장
    private final HashMap<Long, List<Order>> storedOrder = new HashMap<>();

    private long sequence = 0;

    @Override
    public Order save(Order order, Long quantity) {

        List<Order> orders = storedOrder.get(order.getMemberId());

        if(orders == null) {
            orders = new ArrayList<>();
        }
        order.setOrderId(++sequence);
        orders.add(order);
        storedOrder.put(order.getMemberId(), orders);

        return order;
    }

    //현재 로그인된 memberId를 가지고 있으므로 가능함
    @Override
    public List<Order> findMemberOrderedAll(Long memberId) {
        return storedOrder.get(memberId);
    }

    public Order findById(Long id) {
        return new Order();
    }

    @Override
    public boolean update(Long orderId, int quantity) {
        Order order = storedOrder.get(orderId);
        if (order != null) {
            order.setQuantity(quantity);
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Long orderId) {
        storedOrder.remove(orderId);

        return true;
    }
}


