package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido order){
        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessageFromPedido(order);
        sendEmail(simpleMailMessage);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido order) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(order.getClient().getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("PEDIDO CONFIRMADO");
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText(order.toString());

        return simpleMailMessage;
    }
}
