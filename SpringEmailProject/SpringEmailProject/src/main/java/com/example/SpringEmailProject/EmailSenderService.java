package com.example.SpringEmailProject;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com");  // Set sender's email address
        message.setTo(toEmail);                   // Set recipient's email address
        message.setSubject(subject);              // Set the email subject
        message.setText(body);                    // Set the email body content

        try {
            mailSender.send(message);
            System.out.println("Mail Sent...");
        } catch (Exception e) {
            System.err.println("Error sending mail: " + e.getMessage());
        }
    }
}
