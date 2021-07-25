package com.bikefactory.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LogManager.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(CustomerNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("Customer not found");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders httpHeaders, HttpStatus status, WebRequest request) {
        if (body == null) {
            body = Problem.builder()
                    .error(status.getReasonPhrase())
                    .errors(Collections.emptyList())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .error((String) body)
                    .errors(Collections.emptyList())
                    .build();
        }
        return super.handleExceptionInternal(ex, body, getHttpHeaders(), status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(String error, List<String> errors) {
        return Problem.builder()
                .timestamp(LocalDateTime.now())
                .error(error)
                .errors(errors);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "OPTIONS,HEAD,GET,POST,DELETE,PUT, PATCH");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        return headers;
    }

}
