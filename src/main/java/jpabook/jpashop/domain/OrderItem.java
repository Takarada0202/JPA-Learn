package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER+ITEM_ID")
    private Long id;
    private String  name;
    private int price;
    private  int stockOuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getStockOuantity() {
        return stockOuantity;
    }

    public void setStockOuantity(int stockOuantity) {
        this.stockOuantity = stockOuantity;
    }
}