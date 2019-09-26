/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Ebook;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class EbookMapperTest {
    
    @Test
    public void testGetAllEbooks() {
        System.out.println("getAllEbooks");
        EbookMapper instance = new EbookMapper();
        int expResult = 4;
        int result = instance.getAllEbooks().size();
        assertEquals(expResult, result);
    }

//    @Test
//    public void testGetEbookByTitle() {
//        System.out.println("getEbookByTitle");
//        String title = "";
//        EbookMapper instance = new EbookMapper();
//        Ebook expResult = null;
//        Ebook result = instance.getEbookByTitle(title);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testSearchPartOfEbookTitle() {
//        System.out.println("searchPartOfEbookTitle");
//        String title = "";
//        EbookMapper instance = new EbookMapper();
//        List<Ebook> expResult = null;
//        List<Ebook> result = instance.searchPartOfEbookTitle(title);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}
