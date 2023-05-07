package com.groupone.recipeappbackend.user.service;

import com.groupone.recipeappbackend.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    @Autowired
    EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom("noreply@recipehub.com");
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject(subject);
            message.setText(body);

            String htmlContent = body;
            message.setContent(htmlContent, "text/html; charset=utf-8");

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public String contructVerificationHtml(UserDto userDto) {
        String url = "http://localhost:8080/verify?verificationId=" + userDto.getVerificationId();
        return "<h1>Please verify your RecipeHub Account</h1>" +
                "<p>Click the link to verify your account: </p></br>" + "<a href=\"" + url + "\">" + url + "</a>";
    }
}
