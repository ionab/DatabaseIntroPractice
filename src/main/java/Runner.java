import db.DBCustomer;
import db.DBOrder;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Kelsie");
        Customer customer2 = new Customer("Kelsie");
        DBCustomer.save(customer1);
        DBCustomer.save(customer2);
        customer2.setName("TestUpdate");
        DBCustomer.update(customer2);
        DBCustomer.delete(customer1);

        List<Customer> customerList = DBCustomer.getCustomers();

        Order order1 = new Order("TestDescription", 30.0);
        Order order2 = new Order("TestDescription2", 40.0);
        DBOrder.save(order1);
        DBOrder.save(order2);
        order2.setDescription("TestUpdate");
        DBOrder.update(order2);
        DBOrder.delete(order1);

        List<Order> orderList = DBOrder.getOrders();

    }

}
