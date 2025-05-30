package test;

import item.*;
import member.*;
import order.*;

public class OrderTestApp {

    public static void main(String[] args) {

        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        memberService.join(new Member(1L, "hs", "1234", "종빈", Grade.VIP));

        ItemRepository itemRepository = new MemoryItemRepository();
        ItemService itemService = new ItemServiceImpl(itemRepository);
        itemService.registerItem("종강1", 100_000);
        itemService.registerItem("종강2", 200_000);
        itemService.registerItem("종강3", 300_000);
        itemService.registerItem("종강4", 400_000);


        MemberUI memberUI = new MemberUI(memberService);
        ItemUI itemUI = new ItemUI(itemService);

        OrderRepository orderRepository = new MemoryOrderRepository();
        OrderService orderService = new OrderServiceImpl(memberService, itemService, orderRepository);

        OrderUI orderUI = new OrderUI(orderService);
        memberUI.run();

        orderUI.run(memberUI.getCurrentMember());


    }
}
