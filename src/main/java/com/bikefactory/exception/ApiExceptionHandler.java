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

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(PersonNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("Person not found");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @ExceptionHandler(RowGuidNotFoundException.class)
    public ResponseEntity<Object> handleRowGuideMustBeUniqueException(RowGuidNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(RowGuidNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("RowGuide not found!");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @ExceptionHandler(TableEmptyException.class)
    public ResponseEntity<Object> handleCustomerTableEmptyException(TableEmptyException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(TableEmptyException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("This table is empty!");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(ProductNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("Product not found!");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @ExceptionHandler(SalesOrderHeaderNotFoundException.class)
    public ResponseEntity<Object> handleSalesOrderHeaderNotFoundException(SalesOrderHeaderNotFoundException ex,
                                                                          WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(SalesOrderHeaderNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("Sales order header not found!");
        return handleExceptionInternal(ex, problem, getHttpHeaders(), status, request);
    }

    @ExceptionHandler(SalesOrderDetailNotFoundException.class)
    public ResponseEntity<Object> handleSalesOrderHeaderNotFoundException(SalesOrderDetailNotFoundException ex,
                                                                          WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Problem problem = createProblemBuilder(SalesOrderDetailNotFoundException.EXCEPTION_CODE, Collections.emptyList()).build();
        LOG.warn("Sales order detail not found!");
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
