/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.ac.iul.mvcproject.models;
import java.util.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;

/**
 *
 * @author mohammad-mustafa
 */
public class SendMail {
    public void mailSender(String to, int uid) {
        final String username = "mustafagdgc@gmail.com";
        final String password = "dzuv bshn mzpt ckvo";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("Confirm Your Email");
            
            String verificationUrl = "http://localhost:8080/mvcproject/fc/models/emailConfirmation?uid="+uid;
            
            String message =
                "Hello,\n\n"
                + "Thank you for registering.\n\n"
                + "Please click the link below to confirm your email:\n\n"
                + verificationUrl
                + "\n\nThank you.";
            
            msg.setText(message);
            Transport.send(msg);
            
            System.out.println("Confirmation email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
