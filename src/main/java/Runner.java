import db.DBCustomer;
import db.DBHelper;
import db.DBOrder;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Kelsie");
        Customer customer2 = new Customer("Kelsie");
        DBHelper.save(customer1);
        DBHelper.save(customer2);
        customer2.setName("TestUpdate");
        DBCustomer.update(customer2);
//        DBCustomer.delete(customer1);

        List<Customer> customerList = DBCustomer.getCustomers();

        Order order1 = new Order("TestDescription", 30.0, customer1);
        Order order2 = new Order("TestDescription2", 40.0, customer1);
        DBHelper.save(order1);
        DBHelper.save(order2);
        order2.setDescription("TestUpdate");
        DBOrder.update(order2);
//        DBOrder.delete(order1);

        List<Order> orderList = DBOrder.getOrders();

        List<Order> customer1Orders = DBCustomer.getOrdersForCustomer(customer1);

    }

}
