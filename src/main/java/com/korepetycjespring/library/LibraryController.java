package com.korepetycjespring.library;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Integer bookId) {
        return this.libraryService.getById(bookId);
    }

    @GetMapping("/search")
    public List<Book> getByTitle(@RequestParam String title) {
        return libraryService.getByTitle(title);
    }

    @GetMapping
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return this.libraryService.update(book);
    }

    //TODO
    // @PathMapping - aktualizacja tylko danych, które przyszły. Jak będziemy mieć dto, to napiszemy dwie metody.
    // Metoda dla Put'a wymieni całą encje, path będzie aktualizował wybrane/ustawione w body dane.
    // W Pathu można pomyśleć o specjalnym Dto, aby wyrazić róznicę. A id przesłać jako PathVariable.

    @DeleteMapping("/{bookId}")
    public void deleteById(@PathVariable("bookId") Integer bookId) {
        this.libraryService.deleteBook(bookId);
    }
}
