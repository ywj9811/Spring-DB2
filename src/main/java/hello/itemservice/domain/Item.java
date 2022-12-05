package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    /**
     * 사실 itemName의 경우 item_name과
     * 자동으로 매칭이 되기 때문에 @Column은 생략해도 상관없다.
     */
    private Integer price;
    private Integer quantity;

    public Item() {
        /**
         * JPA는 기본 생성자가 필수이다 (public 혹은 protected)
         */
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
