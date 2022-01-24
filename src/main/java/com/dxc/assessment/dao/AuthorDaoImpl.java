package com.dxc.assessment.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.dxc.assessment.modal.Author;

public class AuthorDaoImpl implements AuthorDao{

    private static final String INSERT_ONE_AUTHOR;
    private static final String SELECT_ALL_AUTHOR;
    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final String URL;
    private static final String SELECT_BY_ID;
    private static final String SELECT_BY_GENRE;





    static{
        INSERT_ONE_AUTHOR= " INSERT INTO author(firstName,lastname,genre,email) VALUES (?,?,?,?)";
        SELECT_ALL_AUTHOR=" SELECT * FROM author";
        SELECT_BY_ID = "Select * from author where id = ? ";
        SELECT_BY_GENRE = "select * from author where genre=? ";

        USER_NAME="root";
        PASSWORD="password";
        URL="jdbc:mysql://localhost:3306/dxc";
    }





    @Override
    public void create(Author author) throws SQLException {
        // TODO Auto-generated method stub
        System.out.println( INSERT_ONE_AUTHOR);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement( INSERT_ONE_AUTHOR)) {
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2,author.getLastName());
            preparedStatement.setString(3, author.getGenre());
            preparedStatement.setString(4, author.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }





    















    @Override
    public List<Author> findAll() throws SQLException {

        List < Author > author = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id =rs.getInt("id");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastname");
                String genre = rs.getString("genre");
            
                String email = rs.getString("email");
                author.add(new Author(id, firstname,lastname,genre, email));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return author;
    }
        





    @Override
    public Author findByGenre(String genre) throws SQLException {

        Author author= null;
        
        // Step 1: Establishing a Connection
        try (Connection connection =DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_GENRE);) {
            preparedStatement.setString(1, genre);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id =rs.getInt("id");
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastname");
            
                String email = rs.getString("email");
                author = new Author(id,firstname, lastname, genre,email);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return author;
    
    }





    @Override
    public Author findById(int id) throws SQLException {
        Author author= null;
        
        // Step 1: Establishing a Connection
        try (Connection connection =DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String firstname = rs.getString("firstName");
                String lastname = rs.getString("lastname");
                String genre = rs.getString("genre");
                String email = rs.getString("email");
                author = new Author(id,firstname, lastname, genre,email);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return author;
        
        
    }











}