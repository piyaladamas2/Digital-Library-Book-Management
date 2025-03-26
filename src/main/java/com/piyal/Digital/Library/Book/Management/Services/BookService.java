package com.piyal.Digital.Library.Book.Management.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.piyal.Digital.Library.Book.Management.Entity.Book;

@Service
public class BookService {

  private final Map<Long, Book> bookStorage = new HashMap<>();
  private long bookIdCounter = 1; // Auto-incrementing ID

  // Add a book
  public Book addBook(Book book) {
    book.setId(bookIdCounter++);
    bookStorage.put(book.getId(), book);
    return book;
  }

  // View all books
  public List<Book> getAllBooks() {
    return new ArrayList<>(bookStorage.values());
  }

  // Search book by ID
  public Optional<Book> getBookById(Long id) {
    return Optional.ofNullable(bookStorage.get(id));
  }

  // Search book by title
  public List<Book> getBooksByTitle(String title) {
    List<Book> results = new ArrayList<>();
    for (Book book : bookStorage.values()) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        results.add(book);
      }
    }
    return results;
  }

  // Update book details
  public Optional<Book> updateBook(Long id, Book updatedBook) {
    if (bookStorage.containsKey(id)) {
      updatedBook.setId(id);
      bookStorage.put(id, updatedBook);
      return Optional.of(updatedBook);
    }
    return Optional.empty();
  }

  // Delete a book
  public boolean deleteBook(Long id) {
    return bookStorage.remove(id) != null;
  }

  // Exit system
  public void exitSystem() {
    System.exit(0);
  }
}
