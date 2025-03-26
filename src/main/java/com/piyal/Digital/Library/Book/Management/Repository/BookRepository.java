package com.piyal.Digital.Library.Book.Management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piyal.Digital.Library.Book.Management.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
  Optional<Book> findByTitle(String title);
}
