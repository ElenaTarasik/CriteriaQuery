package query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import query.pojo.MyOrder;
import query.pojo.MyOrderItem;
import query.util.HibernateUtil;

public class MainClass {

    public static void main (String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();


        MyOrder order1 = new MyOrder();
        order1.setName("hats");
        order1.setSend(true);
        order1.setCustomer("Lena");

        MyOrderItem item1 = new MyOrderItem();
        item1.setName("bighat");
        item1.setColor("red");
        item1.setSize(54);
        item1.setMaker("Turkey");
        item1.setPrice(12.5);
        item1.setOrder(order1);

        MyOrderItem item2 = new MyOrderItem();
        item2.setName("smallhat");
        item2.setColor("blue");
        item2.setSize(54);
        item2.setMaker("Russia");
        item2.setPrice(13.5);
        item2.setOrder(order1);

        MyOrderItem item3 = new MyOrderItem();
        item3.setName("oldhat");
        item3.setColor("blue");
        item3.setSize(52);
        item3.setMaker("Russia");
        item3.setPrice(14.4);
        item3.setOrder(order1);

        order1.setTotalPrice(item1.getPrice() + item2.getPrice() + item3.getPrice());

        order1.getItems().add(item1);
        order1.getItems().add(item2);
        order1.getItems().add(item3);

        MyOrder order2 = new MyOrder();
        order2.setName("dresses");
        order2.setSend(false);
        order2.setCustomer("Lesha");

        MyOrderItem item4 = new MyOrderItem();
        item4.setName("bigdress");
        item4.setColor("red");
        item4.setSize(44);
        item4.setMaker("Turkey");
        item4.setPrice(55.3);
        item4.setOrder(order2);

        MyOrderItem item5 = new MyOrderItem();
        item5.setName("smalldress");
        item5.setColor("green");
        item5.setSize(46);
        item5.setMaker("Germany");
        item5.setPrice(33.6);
        item5.setOrder(order2);

        MyOrderItem item6 = new MyOrderItem();
        item6.setName("dress");
        item6.setColor("blue");
        item6.setSize(46);
        item6.setMaker("Russia");
        item6.setPrice(44.2);
        item6.setOrder(order2);

        order2.setTotalPrice(item4.getPrice() + item5.getPrice() + item6.getPrice());

        order2.getItems().add(item4);
        order2.getItems().add(item5);
        order2.getItems().add(item6);

        session.persist(order1);
        session.persist(order2);

        transaction.commit();
        session.close();
    }
}
