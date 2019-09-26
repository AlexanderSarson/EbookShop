/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alex
 */
public class EbookTest {
    Ebook ebook;
    
    @Before
    public void setUp(){
        ebook = new Ebook(1, "Harry Potter", "Rowling", 10);
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Ebook instance = ebook;
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Ebook instance = ebook;
        String expResult = "Harry Potter";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Ebook instance = ebook;
        String expResult = "Rowling";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Ebook instance = ebook;
        int expResult = 10;
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }
    
}
