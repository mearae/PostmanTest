package com.example.demo.core.error;

import com.example.demo.core.error.exception.Exception400;
import com.example.demo.core.error.exception.Exception404;
import com.example.demo.core.error.exception.Exception500;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ** 예외처리를 편하게 해줌
@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> badRequest(Exception400 e){
        return new ResponseEntity<>(e.body(),e.status());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> notFound(Exception404 e){
        return new ResponseEntity<>(e.body(),e.status());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(Exception500 e){
        return new ResponseEntity<>(e.body(),e.status());
    }
}
