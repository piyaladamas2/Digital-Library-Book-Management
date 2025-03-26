package com.piyal.Digital.Library.Book.Management.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyal.Digital.Library.Book.Management.Entity.Book;
import com.piyal.Digital.Library.Book.Management.Repository.BookRepository;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Optional<Book> searchBookById(Long id) {
    return bookRepository.findById(id);
  }

  public Optional<Book> searchBookByTitle(String title) {
    return bookRepository.findByTitle(title);
  }

  public Book updateBook(Long id, Book bookDetails) {
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Book not found"));
    book.setTitle(bookDetails.getTitle());
    book.setAuthor(bookDetails.getAuthor());
    book.setGenre(bookDetails.getGenre());
    book.setAvailabilityStatus(bookDetails.getAvailabilityStatus());
    return bookRepository.save(book);
  }

  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }
}
