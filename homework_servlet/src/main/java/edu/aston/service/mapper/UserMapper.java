package edu.aston.service.mapper;

import edu.aston.entity.Book;
import edu.aston.entity.User;
import edu.aston.model.UserDto;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

  public static UserDto toDto(User user) {
    UserDto dto = new UserDto();
    dto.setUsername(user.getUsername());
    List<String> books = new ArrayList<>();
    for (Book book : user.getBooks()) {
      books.add(book.getTitle());
    }
    dto.setBooks(books);
    return dto;
  }

  public static User fromDto(UserDto dto) {
    User user = new User();
    user.setUsername(dto.getUsername());
    List<Book> books = new ArrayList<>();
    for (String title : dto.getBooks()) {
      books.add(new Book(title));
    }
    user.setBooks(books);
    return user;
  }
}
