/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNPM;

/**
 *
 * @author Admin
 */
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class BookModify {
    
    public static List<Book> findAll() {
        
        List<Book> bookList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            //lay tat ca danh sach sach
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "");

            //tao cau lenh truy van
            String sql = "select * from book";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("author"), rs.getInt("quantity"), rs.getInt("price"));
                bookList.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return bookList;
    }

    public static void insert(Book b) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "");

            //query
            String sql = "insert into book (name , author , quantity , price) values(?,?,?,?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, b.getName());
            statement.setString(2, b.getAuthor());
            statement.setInt(3, b.getQuantity());
            statement.setInt(4, b.getPrice());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Book b) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "");

            //query
            String sql = "update book set name=?,author=?,quantity=?,price=? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, b.getName());
            statement.setString(2, b.getAuthor());
            statement.setInt(3, b.getQuantity());
            statement.setInt(4, b.getPrice());
            statement.setInt(5, b.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "");

            //query
            String sql = "delete from book where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<Book> findbyName(String name) {
        
        List<Book> bookList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sach
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_management", "root", "");

            //tao cau lenh truy van
            String sql = "select * from book where name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("author"), rs.getInt("quantity"), rs.getInt("price"));
                bookList.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc
        return bookList;
    }
    
}
