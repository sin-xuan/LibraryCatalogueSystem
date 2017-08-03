/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Book;

/**
 *
 * @author zx
 */
public class NewClass {
    public static void main(String[] arg) throws Exception{
      JPALibraryCatalogueSystemImpl j = new JPALibraryCatalogueSystemImpl();
      Book b=new Book();
      j.addBook(b);
    }
}
