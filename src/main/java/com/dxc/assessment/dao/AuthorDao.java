package com.dxc.assessment.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao {

    Author create(Author author) throws SQLException;

    ArrayList findById(Long id) throws SQLException;
    
    List<Author> findByGenre(String genre) throws SQLException;

    List<Author> findAll() throws SQLException;
    
}
