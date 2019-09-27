/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ShoppingCart {

    List<Ebook> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public List<Ebook> getShoppingCard() {
        return cart;
    }

    public void setShoppingCard(List<Ebook> cart) {
        this.cart = cart;
    }

    public void addEbook(Ebook ebook) {
        for (Ebook book : cart) {
            if (book.getId() == ebook.getId()) {
                int qty = book.getQty() + ebook.getQty();
                book.setQty(qty);
                return;
            }
        } 
        cart.add(ebook);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Ebook ebook : cart) {
            builder.append(ebook).append("\n");
        }
        return builder.toString();
    }

}
