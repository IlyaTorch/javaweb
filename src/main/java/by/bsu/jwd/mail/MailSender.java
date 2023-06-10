package by.bsu.jwd.mail;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {
    public static String getPropertyByName(String propName) throws IOException {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("/Users/ilyatorch/IdeaProjects/EPAM-Labs/javaweb/src/main/resources/mail.properties"))){
            props.load(in);
        }

        return props.getProperty(propName);
    }

    public void sendEmail(String toEmail, String body) throws IOException {
        String from = getPropertyByName("username");
        String password = getPropertyByName("password");

        String host = "smtp.mail.ru";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }

        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Alert From the University!");
            message.setText(body);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
