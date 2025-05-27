package order;

import order.discount.DiscountPolicy;

import java.util.List;

public class OrderServiceImpl implements OrderService{
//    private final MemberService memberService;
//    private final ItemService itemService;
    public final DiscountPolicy discountPolicy;


    public OrderServiceImpl(DiscountPolicy discountPolicy) {

        this.discountPolicy = discountPolicy;
    };

//    public OrderServiceImpl(MemberService memberService, ItemService itemService, DiscountPolicy discountPolicy) {
//        this.memberService = memberService;
//        this.itemService = itemService;
//        this.discountPolicy = discountPolicy;
//    };


    @Override
    public Order registerOrder(Order order) {

        return newOrder;
    }

    @Override
    public void ListOrders() {

    }

    @Override
    public List<Order> getALLOrders() {
        return List.of();
    }

    @Override
    public List<Order> getOrder() {
        return List.of();
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
