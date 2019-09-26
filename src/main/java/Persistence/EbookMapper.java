/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Ebook;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ebook> searchPartOfEbookTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        EbookMapper mapper = new EbookMapper();
        List<Ebook> books = mapper.getAllEbooks();
    }

}
