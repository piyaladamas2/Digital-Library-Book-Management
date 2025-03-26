package com.piyal.Digital.Library.Book.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.piyal.Digital.Library.Book.Management.Entity.Book;
import com.piyal.Digital.Library.Book.Management.Services.BookService;

import jakarta.validation.Valid;

public class BookController {
  @Autowired
  private BookService bookService;

  @PostMapping
  public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
    return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> searchBookById(@PathVariable Long id) {
    return bookService.searchBookById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    return ResponseEntity.ok(bookService.updateBook(id, bookDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }
}
