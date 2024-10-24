package com.anoshindanil.springmail.controller;

import com.anoshindanil.springmail.model.Message;
import com.anoshindanil.springmail.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")

    public ResponseEntity<String> sendEmail(@RequestBody Message message) {
        System.out.println("Server is working");
        try {
            emailService.sendEmail(message.getTo(), message.getFrom(), message.getSubject(), message.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error sending email");
        }

        return ResponseEntity.status(200).body("Email sent");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getEmail() {
        return ResponseEntity.status(200).body("Server is working");
    }
}
