package com.korepetycjespring.library;

import com.korepetycjespring.library.exceptions.InvalidBookException;
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

    //todo Jeśli dane wejsciowe nie zawieraja tytulu, autora lub roku publikacji nalezy wyrzucic wyjatek typu runtime InvalidBookException.
    public Book addBook(Book book) {
        assertBook(book);
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    // assert czesto wykorzystywane slowo jak leci wyjatek
    // null jest wyjatkowy do niego przyrownuje zawsze za pomoca ==
    // | - wykona wszystkie warunki a || - optymalizuje
    private void assertBook(Book book) {
        if (book.getTitle() == null || book.getAuthor() == null || book.getPublicationYear() == null) {
            throw new InvalidBookException("Ksiazka nie ma wszystkich informacji");
        }
    }

    public void deleteBook(Integer id) {
        Book book = this.getById(id);
        this.books.remove(book);
    }

    public Book update(Book book) {
        Book bookToChange = this.getById(book.getId());
        bookToChange.setAuthor(book.getAuthor());
        bookToChange.setTitle(book.getTitle());
        bookToChange.setPublicationYear(book.getPublicationYear());
        return bookToChange;
    }
}
