package com.joaobarbosadev.BarbosaShop.Exceptions.handlers;

import com.joaobarbosadev.BarbosaShop.Exceptions.ControllerNotFoundException;
import com.joaobarbosadev.BarbosaShop.Exceptions.DataBaseException;
import com.joaobarbosadev.BarbosaShop.Exceptions.components.StandardError;
import com.joaobarbosadev.BarbosaShop.Utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ControllerNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setMessage(e.getMessage());
        error.setError("Recurso não encontrado");
        error.setPath(request.getRequestURI());
        error.setStatus(status.value());
        error.setTimestamp(Utils.getFormatterInstance());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request) {
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        error.setMessage(e.getMessage());
        error.setError("Erro de integridade");
        error.setPath(request.getRequestURI());
        error.setStatus(status.value());
        error.setTimestamp(Utils.getFormatterInstance());
        return ResponseEntity.status(status).body(error);
    }
}
