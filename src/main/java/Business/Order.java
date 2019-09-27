/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;

/**
 *
 * @author Alex
 */
public class Order {
    Customer customer;
    ShoppingCart cart;

    public Order(Customer customer, ShoppingCart cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Ebook> getEbooks() {
        return cart.getShoppingCard();
    }

    
}
