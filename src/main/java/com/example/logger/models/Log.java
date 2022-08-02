package com.example.logger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
    @Id
    public int id;
    public String content;

    public Log() {}

    public Log(int id, String content) {
        this.id = id;
        this.content = content;
    }
}
