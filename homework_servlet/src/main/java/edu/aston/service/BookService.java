package edu.aston.service;

import edu.aston.entity.Book;
import edu.aston.model.BookDto;
import edu.aston.repository.BookRepository;
import edu.aston.service.mapper.BookMapper;

public class BookService {

  private final BookRepository repository = new BookRepository();

  public void addBook(BookDto bookDto) {
    Book book = BookMapper.fromDto(bookDto);
    repository.addBook(book);
  }

  public BookDto getBook(String title) {
    Book book = repository.getBookByTitle(title);
    return BookMapper.toDto(book);
  }

  public void updateBook(BookDto bookDto) {
    Book book = BookMapper.fromDto(bookDto);
    repository.updateBook(book);
  }

  public void deleteBook(String title) {
    repository.deleteBook(title);
  }

}
