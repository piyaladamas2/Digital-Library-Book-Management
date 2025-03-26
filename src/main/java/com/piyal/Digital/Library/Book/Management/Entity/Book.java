package com.piyal.Digital.Library.Book.Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

  @Id
  @GeneratedValue
  private long id;

  @NotEmpty(message = "Title cannot be empty")
  private String title;

  @NotEmpty(message = "Author cannot be empty")
  private String author;
  private String genre;

  @Enumerated(EnumType.STRING)
  private AvailabilityStatus availabilityStatus;

}
