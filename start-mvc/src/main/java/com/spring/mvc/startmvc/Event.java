package com.spring.mvc.startmvc;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
public class Event {

    private String name;
    private int limit;
    private LocalDateTime start;
    private LocalDateTime end;
}
