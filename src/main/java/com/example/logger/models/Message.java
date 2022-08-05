package com.example.logger.models;

public class Message {
    private String from;
    private String to;
    private String content;

    public Message() {}
    public Message(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String GetFrom() {return this.from;}
    public String GetTo() {return this.to;}
    public String GetContent() {return this.content;}

    public void SetFrom(String from) {this.from = from;}
    public void SetTo(String to) {this.to = to;}
    public void SetContent(String content) {this.content = content;}

}
