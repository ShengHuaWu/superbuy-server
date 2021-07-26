package org.shenghuawu.superbuy.items;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Use this class to convert the exceptions to response entity properly
@ControllerAdvice
public class ItemsControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return ResponseEntity.notFound().build();
    }
}
