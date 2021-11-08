package com.korepetycjespring.library;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public Book getById(Integer bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book with id: " + bookId + " doesnt exist."));
    }

    public List<Book> getByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }
}
