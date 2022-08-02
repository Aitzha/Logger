package com.example.logger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {
    @Id
    public int id;
    public String command;
    public String content;

    public Request() {}

    public Request(int id, String command, String content) {
        this.id = id;
        this.command = command;
        this.content = content;
    }
}
