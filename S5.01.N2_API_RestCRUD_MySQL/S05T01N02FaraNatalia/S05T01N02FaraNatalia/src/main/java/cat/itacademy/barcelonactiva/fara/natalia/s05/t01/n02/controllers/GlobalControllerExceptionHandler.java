package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNoData;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n02.models.exceptions.FlorNotListFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?> handleFlorNotFound(FlorNotFoundException ignoredEx){
        return new ResponseEntity<>("Error P-401", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?>handlerFlorListNotValid(FlorNotListFoundException ex){
        return new ResponseEntity<>("Error P-403", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    @ResponseStatus
    public ResponseEntity<?>handlerFlorNoData(FlorNoData ex){
        return new ResponseEntity<>("Error P-402", HttpStatus.NO_CONTENT);
    }
}
