package com.example.backend.api;

import com.example.backend.models.Email;
import com.example.backend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailApi {

    @Autowired
    EmailService emailService;

    @RequestMapping("/contactpartner")
    public void contactPartner(@RequestBody Email email){

        try{
            emailService.sendEmail(email);
        }
        catch (MailException e){
            System.out.println(e);
        }
    }
}
