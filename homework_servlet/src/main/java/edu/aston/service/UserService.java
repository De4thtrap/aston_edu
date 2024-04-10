package edu.aston.service;

import edu.aston.entity.Book;
import edu.aston.entity.User;
import edu.aston.model.UserDto;
import edu.aston.repository.BookRepository;
import edu.aston.repository.UserRepository;
import edu.aston.service.mapper.UserMapper;

public class UserService {

  UserRepository userRepository = new UserRepository();
  BookRepository bookRepository = new BookRepository();

  public void addUser(UserDto userDto) {
    User user = UserMapper.fromDto(userDto);
    for (Book book : user.getBooks()) {
      book.setRequested(1);
      bookRepository.addBook(book);
      userRepository.addUser(new User(user.getUsername(), book));
    }
  }

  public UserDto getUser(String username) {
    User user = userRepository.getUserByName(username);
    return UserMapper.toDto(user);
  }

  public void updateUser(UserDto userDto) {
    userRepository.updateUser(UserMapper.fromDto(userDto));
  }

  public void deleteUser(String username) {
    User user = userRepository.getUserByName(username);
    for (Book book : user.getBooks()) {
      bookRepository.decrementRequested(book);
    }
    userRepository.deleteUser(username);
  }
}
