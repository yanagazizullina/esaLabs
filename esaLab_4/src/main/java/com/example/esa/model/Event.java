package com.example.esa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "change_type")
    private String changeType;

    @Column(name = "entity_class")
    private String entityClass;

    @Column(name = "entity_field")
    private String entityField;

    public Event(){}

    public Event(String id, String changeType, String entityClass, String entityField) {
        this.id = id;
        this.changeType = changeType;
        this.entityClass = entityClass;
        this.entityField = entityField;
    }
}
