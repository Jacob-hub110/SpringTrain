package com.korepetycjespring.library;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("books")
public class LibraryController {

    //Ponizsza linijka jest zastapiona adnotacja lombok @Slf4j
    //Obiekt sluzy do logowania
    //private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    private final LibraryService libraryService;

    /**
     * Adnotacja ExceptionHandler sprawia, że jeśli wystąpi w tym kontrolerze IllegalArgumentException
     * to kod z metody handleException zostanie wykonany.
     * <p>
     * Argumenty w metodzie są opcjonalne, powinny zostac uzupełnione przez framework
     * <p>
     * Adnotacja ResponseStatus sprawi, ze endpoint w przypadku wystapienia wyjatku zwroci wybrany status http.
     * Bez tej adnotacji, zostalby zwrocony status 200 ok.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleException(HttpServletRequest request, IllegalArgumentException e) {
        final String exceptionMessage = e.getMessage();
        log.error(request.getMethod() + " " + request.getRequestURL() + " with error: " + exceptionMessage);
        log.error(ExceptionUtils.getStackTrace(e));
        return ErrorDto.builder()
                .message(exceptionMessage)
                .build();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Integer bookId) {
        return libraryService.getById(bookId);
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
