package order;

import item.ItemService;
import member.MemberService;
import order.discount.DiscountPolicy;
import member.Member;
import item.Item;
import order.discount.FixedDiscountPolicy;
import order.discount.RateDiscountPolicy;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderRepository repository;
    private final DiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy();
    private final DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();


    public OrderServiceImpl(MemberService memberService, ItemService itemService, OrderRepository repository) {
        this.memberService = memberService;
        this.itemService = itemService;
        this.repository = repository;
    }


    @Override
    public Order registerOrder(Long memberId, Long itemId, int quantity) {

        Member member = memberService.findById(memberId);

        Item item = itemService.getItem(itemId);

        int itemPrice = item.getPrice();

        int fixedDiscount = fixedDiscountPolicy.discount(member, itemPrice);
        int rateDiscount = rateDiscountPolicy.discount(member, itemPrice);
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
    public Order getOrder(Long orderId) {
        return repository.findById(orderId);
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
        if (itemService.getItem(itemId) == null) {
            throw new NumberFormatException("올바른 상품 ID를 입력해주세요.");
        }
    }
}
