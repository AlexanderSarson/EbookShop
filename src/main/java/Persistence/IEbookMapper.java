/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Business.Ebook;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface IEbookMapper {
    public List<Ebook> getAllEbooks();
    public Ebook getEbookByTitle(String title);
    public List<Ebook> searchPartOfEbookTitle(String title);
    public Ebook getEbookByID(int id);
}
