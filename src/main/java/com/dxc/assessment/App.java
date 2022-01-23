package com.dxc.assessment;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.dao.AuthorDaoImpl;
import com.dxc.assessment.modal.Author;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        System.out.println( "Hello World!" );
        Author swetha = new Author("swetha", "shetty", "11th","swe@gmail.com");
        Author rahul = new  Author("rahul", "muppirishetty", "4th","rahul@gmail.com");
        Author sai = new  Author("sai", "reddy", "10th","sai@gmail.com");
        

         Author author = (Author) List.of(swetha,rahul,sai);
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.create(author);
        System.out.println(authorDao.create(author));


      
        
        
        
    }

    
    
}
