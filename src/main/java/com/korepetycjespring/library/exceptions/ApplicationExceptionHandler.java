package com.korepetycjespring.library.exceptions;

import com.korepetycjespring.library.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    //Ponizsza linijka jest zastapiona adnotacja lombok @Slf4j
    //Obiekt sluzy do logowania
    //private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    /*
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
                .timestamp(LocalDateTime.now())
                .message(exceptionMessage)
                .path(request.getRequestURI())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
