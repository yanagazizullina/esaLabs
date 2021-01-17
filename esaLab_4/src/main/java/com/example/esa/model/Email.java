package com.example.esa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emails")
public class Email {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "body")
    private String body;

    public Email() { }

    public Email(String id, String body) {
        this.id = id;
        this.body = body;
    }
}
