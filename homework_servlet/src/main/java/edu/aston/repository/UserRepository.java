package edu.aston.repository;

import edu.aston.entity.Book;
import edu.aston.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

  public Connection connectDB() {
    Connection connection = null;
    try {
      Class.forName("com.postgresql.jdbc.Driver");

      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/booksharedb",
          "postgres", "postgres");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }

  public void addUser(User user) {
    String query = "INSERT INTO users VALUES (?, ?)";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getBooks().get(0).getTitle());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public User getUserByName(String username) {
    User user = new User();
    List<Book> books = new ArrayList<>();
    String query = "SELECT * FROM users WHERE username = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        user.setUsername(resultSet.getString("username"));
        books.add(new Book(resultSet.getString("book")));
      }
      user.setBooks(books);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  public void updateUser(User user) {
    //todo fix model
    String query = "UPDATE user SET  = ? WHERE  = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getBooks().get(0).getTitle());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteUser(String title) {
    String query = "DELETE FROM users WHERE username = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, title);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
