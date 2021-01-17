package com.example.esa.JMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private String sendEmail = "yanazulina@gmail.com";
    private final JavaMailSender mailSender;

    @Autowired
    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String changeType, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendEmail);
        message.setFrom("Spring");
        message.setSubject(changeType);
        message.setText(body);
        mailSender.send(message);
    }
}
