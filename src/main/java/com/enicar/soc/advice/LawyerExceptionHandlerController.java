package com.enicar.soc.advice;


import com.enicar.soc.exceptions.*;
import com.enicar.soc.models.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LawyerExceptionHandlerController {

    @ExceptionHandler(LawyerAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handlerLawyerAlreadyExistException(LawyerAlreadyExistsException ex, HttpServletRequest request){
        // Création de l'objet de réponse d'erreur
        ErrorMessage errorResponse = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.CONFLICT.value(),
                request.getRequestURI()
        );

        // Retourne la réponse d'erreur avec un code HTTP 409 (Conflit)
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        ErrorMessage errorResponse = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
        ErrorMessage errorResponse = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<ErrorMessage> handleMethodNotAllowedException(MethodNotAllowedException ex, HttpServletRequest request) {
        ErrorMessage errorResponse = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ErrorMessage> handleTimeoutException(TimeoutException ex, HttpServletRequest request) {
        ErrorMessage errorResponse = new ErrorMessage(
                ex.getMessage(),
                HttpStatus.REQUEST_TIMEOUT.value(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.REQUEST_TIMEOUT);
    }



}
