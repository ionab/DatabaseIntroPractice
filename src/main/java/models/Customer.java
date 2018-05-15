package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customer {

    private String name;
    private int id;
    private Set<Order> orders;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "customer")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
