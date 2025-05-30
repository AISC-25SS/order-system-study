package order;

import item.ItemService;
import member.MemberService;
import order.discount.DiscountPolicy;
import member.Member;
import item.Item;
import order.discount.FixedDiscountPolicy;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final MemberService memberService;
    private final ItemService itemService;
    public final DiscountPolicy discountPolicy;
    private final OrderRepository repository;


    public OrderServiceImpl(MemberService memberService, ItemService itemService, DiscountPolicy discountPolicy, OrderRepository repository) {
        this.memberService = memberService;
        this.itemService = itemService;
        this.discountPolicy = discountPolicy;
        this.repository = repository;
    };


    @Override
    public Order registerOrder(Long memberId, Long itemId, int quantity) {
        //Member에서 가져오기
        Member member = memberService.findById(memberId);

        Item item = itemService.getItem(itemId);

        int itemPrice = item.getPrice();

        int fixedDiscount = discountPolicy.discount(member, itemPrice);
        int rateDiscount = discountPolicy.discount(member, itemPrice);
        int discount = Math.max(fixedDiscount, rateDiscount);

        int finalPrice =  (itemPrice - discount) * quantity;

        Order order = new Order(memberId, itemId,
                                itemPrice, discount,
                                finalPrice, quantity); //여기는 Order객체 생성자 고쳐지면 null삭제

        return repository.save(order);
    }


    @Override
    public List<Order> getALLOrders(Long memberId) {
        return repository.findMemberOrderedAll(memberId);


    }

    @Override
    public Order getOrder(Long memberId) {
        return repository.findById(memberId);
    }


    @Override
    public boolean update(Long orderId, int quantity) {
        Order order = repository.findById(orderId);
        if (order == null) return false;
        repository.update(orderId, quantity);
        return true;
    }

    @Override
    public boolean delete(Long orderId) {
        Order order = repository.findById(orderId);
        if (order == null) return false;
        repository.delete(orderId);
        return true;
    }

    //OrderUI 상품 목록 보여주기 용도
    public List<Item> displayItem() {
        return itemService.getAllItems();
    }

    public void isValidateItemById(Long itemId) {
        if(itemService.getItem(itemId) == null) {
            throw new NumberFormatException();
        }
    }
}
