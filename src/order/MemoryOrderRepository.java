package order;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class MemoryOrderRepository implements OrderRepository {
    private final HashMap<Long, Long> storedOrderId = new HashMap<>();
    private final HashMap<Long, Order> storedOrder = new HashMap<>();
    private long sequence = 0;

    @Override
    public Order save(Order order) {
        order.setOrderId(++sequence);
        store.put(order.getOrderId(), order);
        return null;
    }

    @Override
    public List<Order> findAll() {
        for()
        return new ArrayList<>(storedOrderId.values());
    }

    @Override
    public Order findById(Long orderId) {

    }

    @Override
    public boolean updateOrder(Long orderId, int quantity) {
        Order order = store.get(orderId);
        if(order != null) {
            order.setQuantity(quantity);
        return false;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        store.remove(orderId);

    }
}
}
