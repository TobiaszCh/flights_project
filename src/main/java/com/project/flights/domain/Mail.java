package com.project.flights.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
}
