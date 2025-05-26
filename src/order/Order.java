package order;

public class Order {

    //    멤버변수
    private Long memberId;
    private Long itemId;
    private int itemPrice;
    private int discountPrice;
    private int finalPrice;
    private int quantity;
    private Long orderId;

    //    생성자
    public Order(Long memberId, Long itemId, int itemPrice, int discountPrice, int finalPrice, int quantity, Long orderId) {

        this.memberId = memberId;      // this.변수명 = 입력받을값
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.quantity = quantity;
        this.orderId = orderId;

    }


    //    메소드
    public Long getMemberId() {return memberId;}

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getItemId() {return itemId;}

    public void setItemId(Long itemId) {this.itemId = itemId;}

    public int getItemPrice() {return itemPrice;}

    public void setItemPrice(int itemPrice) {this.itemPrice = itemPrice;}
    //    확인차 출력

    public int getDiscountPrice() {return discountPrice;}

    public void setDiscountPrice(int discountPrice) {this.discountPrice = discountPrice;}

    public int getFinalPrice() {return finalPrice;}

    public void setFinalPrice(int finalPrice) {this.finalPrice = finalPrice;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {return orderId;}

    public void setOrderId(Long orderId) {this.orderId = orderId;}

    @Override
    public String toString() {
        return "[주문] 회원ID: " + memberId +
                ", 상품ID: " + itemId +
                ", 수량: " + quantity +
                ", 상품 가격: " + itemPrice +
                ", 할인 금액: " + discountPrice +
                ", 결제 금액: " + finalPrice;
    }

}





