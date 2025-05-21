package item;

public class Item {
        private Long id;      // 상품 ID
        private String name;  // 상품명
        private int price;    // 가격 (원)

        //Frame work 호환용
        public Item (){ }

        // 신규 사용자 등록용 생성자
        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
        // 모든 필드를 초기화하는 생성자
        public Item(Long id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        // Getter 및 Setter 메서드
        public Long getId() {
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        // 객체 정보를 문자열로 표현
        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

}
