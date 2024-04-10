package edu.aston.service.mapper;

import edu.aston.entity.Book;
import edu.aston.model.BookDto;

public class BookMapper {
  public static BookDto toDto(Book book) {
    BookDto dto = new BookDto();
    dto.setTitle(book.getTitle());
    dto.setRequested(book.getRequested());
    return dto;
  }

  public static Book fromDto(BookDto bookDto) {
    Book book = new Book();
    book.setTitle(bookDto.getTitle());
    book.setRequested(bookDto.getRequested());
    return book;
  }
}
