package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

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

    protected String htmlFromTemplatePedido(Pedido order){
        Context context = new Context();
        context.setVariable("pedido",order);
        return templateEngine.process("email/confirmacaoPedido", context);
    }

    @Override
    public void sendOrderConfirmationHtmlEmail(Pedido order){
        try{
            MimeMessage mineMessage = prepareMimeMessageFromPedido(order);
            sendHtmlEmail(mineMessage);
        } catch (MessagingException e){
            sendOrderConfirmationEmail(order);
        }

    }

    protected MimeMessage prepareMimeMessageFromPedido(Pedido order) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(order.getClient().getEmail());
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setSubject("Pedido Confirmado!");
        mimeMessageHelper.setSentDate(new Date(System.currentTimeMillis()));
        mimeMessageHelper.setText(htmlFromTemplatePedido(order),true);
        return mimeMessage;
    }

    @Override
    public void sendNewPasswordEmail(Client client, String newPass){
        SimpleMailMessage simpleMailMessage = prepareNewPasswordEmail(client, newPass);
        sendEmail(simpleMailMessage);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Client client, String newPass) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(client.getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("SOLICITAÇÃO DE NOVA SENHA");
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText("Nova Senha: " + newPass);
        return simpleMailMessage;
    }
}
