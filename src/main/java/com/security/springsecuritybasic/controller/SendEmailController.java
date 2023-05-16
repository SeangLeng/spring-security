package com.security.springsecuritybasic.controller;

import com.security.springsecuritybasic.service.MailingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class SendEmailController {
    private final MailingService mailingService;
    @PostMapping("/sendEmail")
    public String sendMail(){
        try {
            mailingService.sendingEmail("mr.lengseng@gmail.com","Here is the message from the jenzy!", "Sending love to you!");
            return "successfully sent an email to seangleng507@gmail.com";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ex : " + e.getMessage());
            return "Failed to send email!";
        }
    }
}
