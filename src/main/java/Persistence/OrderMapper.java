/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Customer;
import Business.Ebook;
import Business.Order;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alex
 */
public class OrderMapper {

    public void createOrder(Order order) {
        Customer customer = order.getCustomer();
        List<Ebook> ebooks = order.getEbooks();
        int id = customer.getId();
        String name = customer.getName();
        String phone = "" + customer.getPhoneNumber();
        String email = customer.getEmail();
        String updateSql = "INSERT INTO orders (cust_id,ebook_id,price,qty) VALUES (?,?,?,?)";
        for (Ebook ebook : ebooks) {
            int ebookId = ebook.getId();
            int price = ebook.getPrice();
            int qty = ebook.getQty();
            try {
                PreparedStatement stmt = DB.getConnection().prepareStatement(updateSql);
                stmt.setInt(1, id);
                stmt.setInt(2, ebookId);
                stmt.setInt(3, price);
                stmt.setInt(4, qty);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
