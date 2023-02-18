package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail( String from, String to, String subject, String body) throws MessagingException  {
        MimeMessage message = mailSender.createMimeMessage();
        Address[] address = new Address[]{new InternetAddress("test-email@test.co.uk")};
//        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setRecipient(MimeMessage.RecipientType.TO, address[0]);
        message.setSubject(subject);
//        message.setText(body);
        message.setContent(body, "text/html; charset=utf-8");



        mailSender.send(message);
    }
}