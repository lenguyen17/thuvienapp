package com.raven.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    public EmailSender() {
    }
    
    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        String fromEmail = "lenguyencm97@gmail.com"; // your email address
        String password = "oownsxrjqsyctkgn"; // your email password

        // setup SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server hostname
        props.put("mail.smtp.port", "587"); // SMTP server port
        props.put("mail.smtp.auth", "true"); // enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

        // create a new session with an authenticator
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        // create a new message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        // send the message
        Transport.send(message);

        System.out.println("Email sent to " + toEmail);
    }
    /* TEST 
        try {
            sendEmail("youngpainx17@gmail.com", "Thư viện ITC", "Thông báo: thời gian mượn sách của bạn đã quá hạn, \n"
                    + "vui lòng gia hạn hoặc trả trách tại thư viện trước ngay dd/MM/yyyy \n"
                    + "Xin cảm ơn.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
     */
}
