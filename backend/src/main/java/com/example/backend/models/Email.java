package com.example.backend.models;

public class Email {

    private String replyTo;
    private String to;
    private String subject;
    private String text;

    public Email(String replyTo, String to, String subject, String text) {
        this.replyTo = replyTo;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
