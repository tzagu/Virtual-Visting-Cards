package com.example.backend.services;

import com.example.backend.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Email email)throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("tzaguyapa@gmail.com");
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setReplyTo(email.getReplyTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getText());

        javaMailSender.send(simpleMailMessage);
        System.out.println("Mail sent");

    }
}
