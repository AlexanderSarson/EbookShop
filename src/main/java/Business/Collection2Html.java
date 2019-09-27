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
public class Collection2Html {
    
    public static String ebookList2HtmlTable(List<Ebook> ebooks){
        String out = "<table border=\"1\" cellpadding=\"10\"><thead><tr><th>id</th><th>title</th><th>author</th><th>price</th></tr></thead><tbody>";
        for (Ebook ebook : ebooks) {
            out += " <tr><td>"+ebook.getId()+"</td><td>"+ebook.getTitle()+"</td><td>"+ebook.getAuthor()+"</td><td>"+ebook.getPrice()+"</td></tr>";
        }
        out += "</tbody></table>";
        return out;
    }
    
    public static String ebook2HtmlTable(Ebook ebook){
        String out = "<table border=\"1\" cellpadding=\"10\"><thead><tr><th>id</th><th>title</th><th>author</th><th>price</th></tr></thead><tbody>";
        out += " <tr><td>"+ebook.getId()+"</td><td>"+ebook.getTitle()+"</td><td>"+ebook.getAuthor()+"</td><td>"+ebook.getPrice()+"</td></tr>";
        out += "</tbody></table>";
        return out;
    }
    
    public static String ebook2HtmlForm(Ebook ebook){
        String out = "<form method=\"get\" action=\"OrderServlet\">";
        out += "<table border=\"1\" cellpadding=\"10\"><thead><tr><th> </th><th>title</th><th>author</th><th>price</th></tr></thead><tbody>";
        out += "<tr><td><input type='checkbox' name='id' value="
                + "'" +ebook.getId() + "' /></td><td>"
                + ebook.getTitle() +"</td><td>"
                + ebook.getAuthor() + "</td><td>$"
                + ebook.getPrice() + "</td>";
        
        out += "</tr>";
        out += "</tbody></table>";
        out += "<input type='submit' value='ORDER' />";
        out += "</form>";
        return out;
    }
    
    public static String ebookList2HtmlForm(List<Ebook> ebooks){
        String out = "<form method=\"get\" action=\"OrderServlet\">";
        out += "<table border=\"1\" cellpadding=\"10\"><thead><tr><th> </th><th>title</th><th>author</th><th>price</th></tr></thead><tbody>";
        for (Ebook ebook : ebooks) {
             out += "<tr><td><input type='checkbox' name='id' value="
                + "'" +ebook.getId() + "' /></td><td>"
                + ebook.getTitle() +"</td><td>"
                + ebook.getAuthor() + "</td><td>$"
                + ebook.getPrice() + "</td>";
        }
        out += "</tr>";
        out += "</tbody></table>";
        out += "<input type='submit' value='ORDER' />";
        out += "</form>";
        return out;
    }
}
