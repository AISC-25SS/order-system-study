package order;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class MemoryOrderRepository implements OrderRepository {

    //(memberId, List<order객체>) 저장
    private final HashMap<Long, List<Order>> storedOrder = new HashMap<>();

    private long sequence = 0;

    @Override
    public Order save(Order order) {

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



    @Override
    public boolean update(Long orderId, int quantity) {
        for (List<Order> orders : storedOrder.values()) {
            for (Order order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    order.setQuantity(quantity);
                    return true;
                }
            }
        }
        return false; // 못 찾은 경우
    }

    @Override
    public boolean delete(Long orderId) {
        for (List<Order> orders : storedOrder.values()) {
            for (Order order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    return true;
                }
            }
        }
        return false;
    }
}


