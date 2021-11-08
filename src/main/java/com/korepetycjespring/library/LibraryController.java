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

    @RequestMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Integer bookId) {
        return libraryService.getById(bookId);
    }

    @RequestMapping
    public List<Book> getByTitle(@RequestParam String title){
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

    // todo delete put path
    @DeleteMapping("/{bookId}")
    public void deleteById(@PathVariable("bookId") Integer bookId) {
        //todo
        System.out.println("usuwam");
    }

}
