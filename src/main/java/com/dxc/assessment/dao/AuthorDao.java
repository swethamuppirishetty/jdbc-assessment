package com.dxc.assessment.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao {

    void create(Author author) throws SQLException;

    Author findById(int id) throws SQLException;
    
    Author findByGenre(String genre) throws SQLException;

    List<Author> findAll() throws SQLException;
    
}
