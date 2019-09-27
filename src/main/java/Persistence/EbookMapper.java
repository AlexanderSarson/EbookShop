/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Ebook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class EbookMapper implements IEbookMapper {

    @Override
    public List<Ebook> getAllEbooks() {
        String sql = "SELECT * FROM ebooks";
        List<Ebook> ebooks = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = DB.getConnection().prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ebook ebook = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                ebook = new Ebook(id, title, author, price);
                ebooks.add(ebook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebooks;
    }

    @Override
    public Ebook getEbookByTitle(String title) {
        String sql = "SELECT * FROM ebooks where title = ?";
        ResultSet rs = null;
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
            stmt.setString(1, title);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ebook ebook = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                ebook = new Ebook(id, bookTitle, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebook;
    }

    @Override
    public List<Ebook> searchPartOfEbookTitle(String title) {
        String sql = "SELECT * FROM ebooks where title like \"%" + title + "%\"";
        List<Ebook> ebooks = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ebook ebook = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                ebook = new Ebook(id, bookTitle, author, price);
                ebooks.add(ebook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebooks;
    }
    
    public static void main(String[] args) {
        EbookMapper mapper = new EbookMapper();
        List<Ebook> ebooks = new ArrayList<>();
        ebooks = mapper.searchPartOfEbookTitle("har");
        System.out.println(ebooks.get(0).getTitle());
    }

}
