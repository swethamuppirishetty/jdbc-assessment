package com.dxc.assessment.dao;

import java.sql.SQLException;
import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao {

    Author create(Author author) throws SQLException;

    Author findById(Long id);
    
    List<Author> findByGenre(String genre);

    List<Author> findAll() throws SQLException;
    
}
