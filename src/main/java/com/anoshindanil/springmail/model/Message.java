package com.anoshindanil.springmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private String from;
    private String to;
    private String subject;
    private String body;
}
