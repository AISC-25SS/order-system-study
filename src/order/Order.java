package order;

public class Order{

//    멤버변수
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    private int finalPrice;

//    생성자
    public Order(Long memberId, String itemName) {

        this.memberId = memberId;
        this.itemName = itemName;

    }


//    메소드
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    //    확인차 출력

}


