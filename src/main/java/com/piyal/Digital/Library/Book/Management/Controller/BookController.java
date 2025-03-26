package com.piyal.Digital.Library.Book.Management.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piyal.Digital.Library.Book.Management.Entity.Book;
import com.piyal.Digital.Library.Book.Management.Services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // Add a book
  @PostMapping("/add")
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    return ResponseEntity.ok(bookService.addBook(book));
  }

  // View all books
  @GetMapping("/all")
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  // Search book by ID
  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    Optional<Book> book = bookService.getBookById(id);
    return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Search book by title
  @GetMapping("/search")
  public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam String title) {
    List<Book> books = bookService.getBooksByTitle(title);
    return books.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(books);
  }

  // Update book details
  @PutMapping("/update/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
    return bookService.updateBook(id, updatedBook)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Delete a book
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteBook(@PathVariable Long id) {
    return bookService.deleteBook(id)
        ? ResponseEntity.ok("Book deleted successfully!")
        : ResponseEntity.notFound().build();
  }

  // Exit system
  @PostMapping("/exit")
  public ResponseEntity<String> exitSystem() {
    bookService.exitSystem();
    return ResponseEntity.ok("Exiting system...");
  }
}
