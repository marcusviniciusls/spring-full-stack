package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido order);
    void sendEmail(SimpleMailMessage simpleEmailMessage);
    void sendOrderConfirmationHtmlEmail(Pedido obj);
    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Client client, String newPass);
}
