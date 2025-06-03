package config;

import item.*;
import member.*;
import order.*;

public class AppConfig {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final ItemRepository itemRepository = new MemoryItemRepository();
    private final OrderRepository orderRepository = new MemoryOrderRepository();

    private final MemberService memberService = new MemberServiceImpl(memberRepository);
    private final ItemService itemService = new ItemServiceImpl(itemRepository);
    private final OrderService orderService = new OrderServiceImpl(
            memberService, itemService, orderRepository
    );

    private final MemberUI memberUI = new MemberUI(memberService);
    private final ItemUI itemUI = new ItemUI(itemService);
    private final OrderUI orderUI = new OrderUI(orderService);

    // 초기 Mock 데이터 등록
    public AppConfig() {
        initMockData();
    }

    private void initMockData() {
        // 회원 등록
        memberService.join(new Member(null, "dowon", "1234", "도원", Grade.VIP));
        memberService.join(new Member(null, "seongbin", "1234", "성빈", Grade.BASIC));
        memberService.join(new Member(null, "jongbin", "1234", "종빈", Grade.BASIC));
        memberService.join(new Member(null, "eunhye", "1234", "은혜", Grade.VIP));
        memberService.join(new Member(null, "jihun", "1234", "지훈", Grade.BASIC));


        // 상품 등록
        itemService.registerItem("스타벅스 아메리카노", 4500);
        itemService.registerItem("홈런볼 초코과자", 2200);
        itemService.registerItem("무지 노트북 파우치", 15900);
        itemService.registerItem("샤오미 무선 선풍기", 48000);
        itemService.registerItem("책상용 LED 스탠드", 32000);
    }

    public MemberUI memberUI() {
        return memberUI;
    }

    public ItemUI itemUI() {
        return itemUI;
    }

    public OrderUI orderUI() {
        return orderUI;
    }
}
