package com.dxc.assessment;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.dao.AuthorDaoImpl;
import com.dxc.assessment.modal.Author;
import com.google.protobuf.Internal.LongList;

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


        AuthorDaoImpl dao = new AuthorDaoImpl();
        List<Author> authors =List.of(swetha,rahul,sai);


        authors.forEach(bk -> {
            try {
                dao.create(bk);
                
            } catch (SQLException e) {
                //TODO: handle exception
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });

        System.out.println(dao.findById(2));


        System.out.println(dao.findByGenre("10th"));


        System.out.println(dao.findAll());

        

        
        

      
        
        
        
    }

    
    
}
