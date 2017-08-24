package query.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATE")
    private boolean isSend;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<MyOrderItem> items = new ArrayList<MyOrderItem>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyOrderItem> getItems() {
        return items;
    }

    public void setItems(List<MyOrderItem> items) {
        this.items = items;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
