package query.pojo;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
public class MyOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "MAKER")
    private String maker;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private MyOrder order;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MyOrder getOrder() {
        return order;
    }

    public void setOrder(MyOrder order) {
        this.order = order;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
