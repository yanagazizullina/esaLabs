package com.example.esa.JMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.example.esa.model.Email;
import com.example.esa.model.Event;
import com.example.esa.repository.EmailRepository;
import com.example.esa.repository.EventRepository;


@Component
public class JmsReceiver {
    private final EmailSender emailSender;
    private final EventRepository eventRepository;
    private final EmailRepository emailRepository;

    @Autowired
    public JmsReceiver(EmailSender emailSender, EventRepository eventRepository, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.eventRepository = eventRepository;
        this.emailRepository = emailRepository;
    }

    @JmsListener(destination = "events", containerFactory = "factory")
    public void receiveChange(Event event) {
        eventRepository.save(event);
    }

    @JmsListener(destination = "emails", containerFactory = "factory")
    public void receiveEmail(Email email) {
        email.setEmail(emailSender.getSendEmail());
        emailRepository.save(email);
        emailSender.send(email.getBody(), email.toString());
    }
}
