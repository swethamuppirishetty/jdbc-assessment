package com.dxc.assessment;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.modal.Author;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Author swetha = new Author("swetha", "shetty", "11th","swe@gmail.com");
        Author rahul = new  Author("rahul", "muppirishetty", "4th","rahul@gmail.com");
        Author sai = new  Author("sai", "reddy", "10th","sai@gmail.com");
        

        List<Author> author = List.of(swetha,rahul,sai);
        AuthorDao authorDao = new AuthorDao();

        author.forEach(au-> {
            try {
                Author rows = authorDao.create(au);
                System.out.println("Rows affected: " + rows);
            } catch (SQLDataException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
        
    }
    
}
