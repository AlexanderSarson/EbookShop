/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Alex
 */
public class Ebook implements Comparable<Ebook>{
    private int id;
    private String title;
    private String author;
    private int price;
    private int qty;    

    public Ebook(int id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Ebook{" + "id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", qty=" + qty + '}';
    }

    @Override
    public int compareTo(Ebook ebook) {
        int ebookid = ebook.getId();
        if(id == ebookid){
            return 0;
        } else if(id > ebookid){
            return 1;
        } else {
            return -1;
        }
    }
}
