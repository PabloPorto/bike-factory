package com.bikefactory.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class Problem {

    private final LocalDateTime timestamp;
    private final String error;
    private final List<String> errors;
}