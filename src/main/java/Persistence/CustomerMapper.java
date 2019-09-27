/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class CustomerMapper {
    
    public int getCustomerIdByName(String name) {
        String sql = "SELECT * FROM customers where cust_name = ?";
        ResultSet rs = null;
        int cust_id = -1;
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                cust_id = rs.getInt("ebook_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust_id;
    }
    
    public void createCustomer(Customer customer){
        int id = customer.getId();
        String name = customer.getName();
        String phone = "" + customer.getPhoneNumber();
        String email = customer.getEmail();
        String updateSql = "INSERT INTO customers (cust_id,cust_name,email,phone) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(updateSql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getNextCustomerId(){
        String sql = "Select max(cust_id) from customers";
        ResultSet rs = null;
        int cust_id = 0;
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                cust_id = rs.getInt("max(cust_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust_id + 1;
    }
    
}
